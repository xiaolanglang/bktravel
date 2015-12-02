package com.bkweb.common.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.bkweb.common.dao.interfaces.ICrudDao;
import com.bkweb.common.dao.interfaces.IEnableEntity;
import com.bkweb.common.entity.DataEntity;
import com.bkweb.common.utils.Reflections;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

/**
 * DAO支持类实现，通用增删改差<br>
 * 1、基于Criteria的分页查询，主要是为了获得总记录数 <br>
 * 2、基于Criteria的条件查询，可以使用抓取进行联表查询<br>
 * 3、使用原生态sql语句进行字段较多，sql语句结构较复杂的查询，这里条语句应该是可以放在配置文件中的，暂时不讨论<br>
 * 4、这个地方没有使用到hql的查询方式
 * 
 * <!-- Hibernate只会缓存对象的简单属性的值, 要缓存集合属性,必须在集合元素中也加入<cache>子元素
 * 而Hibernate仅仅是把与当前持久对象关联的对象的OID存放到缓存中。 如果希望把整个关联的对象的所有数据都存入缓存,
 * 则要在相应关联的对象的映射文件中配置<cache>元素 -->
 * 
 * 
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public abstract class CrudDao<T extends DataEntity<T>> implements ICrudDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session session;

	protected Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	protected Criteria getCriteria(Class<?> clz) {
		return getSession().createCriteria(clz);
	}

	@Override
	public void evict(T model) {
		getSession().evict(model);
	}

	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public void clear() {
		getSession().clear();
	}

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(T entity, String... batchTable) {
		return (T) getSession().get(entity.getClass(), entity.getId());
	}

	public List<T> findPageList(T entity, boolean cacheable, HPage<T> page, String... associationPaths) {
		Criteria criteria = getCriteria(entity.getClass());

		criteria.setCacheable(cacheable);

		createCriterion(criteria, entity, associationPaths);

		page.init(page, criteria);
		
		@SuppressWarnings("unchecked")
		List<T> list = criteria.list();
		page.setList(list);
		
		return page.getList();
	}

	public List<T> findList(T entity, boolean cacheable, String... associationPaths) {
		Criteria criteria = getCriteria(entity.getClass());

		createCriterion(criteria, entity, associationPaths);

		@SuppressWarnings("unchecked")
		List<T> list = criteria.setCacheable(cacheable).list();

		return list;
	}

	@Override
	public List<T> findAllList(Class<?> clz, boolean cacheable, String... associationPaths) {

		Criteria criteria = getCriteria(clz);

		if (associationPaths.length > 0) {
			for (int i = 0, l = associationPaths.length; i < l; i++) {
				criteria.createCriteria(associationPaths[i], JoinType.LEFT_OUTER_JOIN);
			}
		}

		@SuppressWarnings("unchecked")
		List<T> list = criteria.setCacheable(cacheable).list();

		return list;
	}

	@Override
	public void saveOrUpdate(T entity) {
		if (StringUtils.isEmpty(entity.getId())) {
			save(entity);
		} else {
			update(entity);
		}
	}

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public void save(T entity) {
		getSession().save(entity);
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @return
	 */
	public void update(T entity) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update " + entity.getClass().getSimpleName() + " set ");
		Map<String, Object> map = new HashMap<String, Object>();

		for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			getUpdateField(buffer, entity, fields, map);
		}
		buffer.deleteCharAt(buffer.length() - 1);

		buffer.append(" where id = :id");

		Query query = getSession().createQuery(buffer.toString());

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			query.setParameter(key, map.get(key));
		}
		query.executeUpdate();

	}

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param entity
	 * @return
	 */
	public void delete(T entity) {
		getSession().createSQLQuery("update " + entity.getClass().getSimpleName() + " set del_flag = 1 where id = :id")
				.setParameter("id", entity.getId()).executeUpdate();
	}

	@Override
	public void trueDelete(T entity) {
		getSession().delete(entity);
	}

	public List<?> sqlQueryList(String sql, Class<?> clz, boolean cacheable) {
		return getSession().createSQLQuery(sql).addEntity(clz).setCacheable(cacheable).list();
	}

	/**
	 * 创建查询标准
	 * 
	 * @param criteria
	 * @param list
	 *            list中的对象需要实现指定接口
	 * @param batch
	 *            当递归第一次运行的时候，这是true，其余的时候都为false<br>
	 *            进行联表查询的创建，这里必须设置为true，如果不设置为true，可能会漏掉需要连接的表
	 * @param batchTable
	 */
	protected void createCriterion(Criteria criteria, IEnableEntity entity, String... associationPaths) {

		for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			getSearchField(criteria, entity, fields);
		}

		if (associationPaths.length == 0) {
			return;
		}

		for (int i = 0, l = associationPaths.length; i < l; i++) {
			String associationPath = associationPaths[i];
			traversalClass(criteria, entity, associationPath);
		}

	}

	/**
	 * 创建查询标准
	 * 
	 * @param criteria
	 * @param list
	 *            list中的对象需要实现指定接口
	 * @param batch
	 *            当递归第一次运行的时候，这是true，其余的时候都为false<br>
	 *            进行联表查询的创建，这里必须设置为true，如果不设置为true，可能会漏掉需要连接的表
	 * @param batchTable
	 */
	@Deprecated
	protected void createCriterionDeprecated(Criteria criteria, List<IEnableEntity> list, boolean batch,
			String... batchTable) {

		if (batch && batchTable.length > 0) {
			for (int i = 0, l = batchTable.length; i < l; i++) {
				// 创建联表查询，使用join方式
				criteria.createCriteria(batchTable[i], JoinType.LEFT_OUTER_JOIN);
			}
		}

		// 创建集合，用于收集遍历过程中查询到的对象
		List<IEnableEntity> entities = new ArrayList<IEnableEntity>();
		for (IEnableEntity entity : list) {// 遍历收集到的实体对象
			makeCriterioDeprecated(criteria, entity, entities, batch, batchTable);
		}
		if (entities.size() > 0) {
			// 使用递归，对收集到的实体集合进行进一步的遍历，创建查询标准
			createCriterionDeprecated(criteria, entities, false, batchTable);
		}

	}

	/**
	 * 获得一个对象中的所有属性，包括父类
	 * 
	 * @param criteria
	 * @param entity
	 * @param associationPath2
	 *            待遍历对象
	 * @param list
	 *            用于收集对象
	 * @param batchTable
	 */
	private void traversalClass(Criteria criteria, IEnableEntity entity, String associationPath) {

		if (associationPath != null) {
			criteria = criteria.createCriteria(associationPath, JoinType.LEFT_OUTER_JOIN);
		}

		// 第一次运行到这里的时候batchFlag为true，其余的时候都为false
		// flag为true表示找到了要遍历的对象，否则就是没找到
		Object iEntity = null;
		try {
			iEntity = Reflections.invokeGetter(entity, associationPath);
		} catch (NullPointerException nullException) {
			// 考虑到这里对象可能为空，所以允许在运行方法的时候出现空指针异常
			// 为空之后，就不需要对属性进行遍历了，所以就返回函数
			return;
		}
		if (iEntity == null) {
			// 如果对象是空的，就不含有属性，无需遍历，直接返回函数
			return;
		}
		for (Class<?> clazz = iEntity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			getSearchField(criteria, (IEnableEntity) iEntity, fields);
		}

	}

	/**
	 * 获得一个对象中的所有属性，包括父类
	 * 
	 * @param criteria
	 * @param entity
	 *            待遍历对象
	 * @param list
	 *            用于收集对象
	 * @param batchTable
	 */
	@Deprecated
	private void makeCriterioDeprecated(Criteria criteria, IEnableEntity entity, List<IEnableEntity> list,
			boolean batchFlag, String... batchTable) {

		boolean flag = false;
		String prefix = null;
		for (String batch : batchTable) {
			if (entity.getClass().getSimpleName().toLowerCase().equals(batch.toLowerCase())) {
				criteria = criteria.createCriteria(batch, JoinType.LEFT_OUTER_JOIN);
				flag = true;
				prefix = batch;
				break;
			}
		}
		// 第一次运行到这里的时候batchFlag为true，其余的时候都为false
		// flag为true表示找到了要遍历的对象，否则就是没找到
		if (flag || batchFlag) {
			for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				Field[] fields = clazz.getDeclaredFields();
				traversalfieldsDeprecated(criteria, entity, fields, list, prefix);
			}
		}

	}

	/**
	 * 对对象属性进行遍历，如果属性值不为空，那就加入搜索条件中，如果对象属性是一个实现了IEnableEntity接口的实体对象，就把该对象放到集合中
	 * 
	 * @param criteria
	 * @param entity
	 * @param fields
	 */
	private void getSearchField(Criteria criteria, IEnableEntity entity, Field[] fields) {
		for (Field field : fields) {
			try {
				String fieldName = field.getName();
				Object fieldValue = Reflections.invokeGetter(entity, fieldName);
				if (fieldValue == null || StringUtils.isEmpty(String.valueOf(fieldValue))) {
					continue;
				}

				if (fieldValue instanceof IEnableEntity) {
					continue;
				}

				String type = field.getType().toString();
				if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double")
						|| type.endsWith("Double") || type.endsWith("long") || type.endsWith("Long")
						|| type.endsWith("short") || type.endsWith("Short") || type.endsWith("char")
						|| type.endsWith("Character") || type.endsWith("float") || type.endsWith("Float")
						|| type.endsWith("byte") || type.endsWith("Byte") || type.endsWith("boolean")
						|| type.endsWith("Boolean") || type.endsWith("String") || type.endsWith("Date")) {
					// System.out.println(entity.getClass().getSimpleName() +
					// ":" + fieldName + ">>>>>>" + fieldValue);
					Criterion c = Restrictions.eq(fieldName, fieldValue);
					criteria.add(c);
				}

			} catch (IllegalArgumentException e) {
				// 允许找不到get方法
			}
		}
	}

	private void getUpdateField(StringBuffer buffer, T entity, Field[] fields, Map<String, Object> map) {
		for (Field field : fields) {
			try {
				String fieldName = field.getName();
				Object fieldValue = Reflections.invokeGetter(entity, fieldName);
				if (fieldValue == null || StringUtils.isEmpty(String.valueOf(fieldValue))) {
					continue;
				}

				// if (fieldValue instanceof IEnableEntity) {
				// continue;
				// }

				String type = field.getType().toString();
				if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("String")
						|| fieldValue instanceof IEnableEntity || type.endsWith("double") || type.endsWith("Double")
						|| type.endsWith("long") || type.endsWith("Long") || type.endsWith("short")
						|| type.endsWith("Short") || type.endsWith("char") || type.endsWith("Character")
						|| type.endsWith("float") || type.endsWith("Float") || type.endsWith("byte")
						|| type.endsWith("Byte") || type.endsWith("boolean") || type.endsWith("Boolean")
						|| type.endsWith("Date")) {

					map.put(fieldName, fieldValue);
					if (fieldName.equals("id")) {
						continue;
					}
					buffer.append(fieldName + " = :" + fieldName + ",");
				}

			} catch (IllegalArgumentException e) {
				// 允许找不到get方法
			}
		}
	}

	/**
	 * 对对象属性进行遍历，如果属性值不为空，那就加入搜索条件中，如果对象属性是一个实现了IEnableEntity接口的实体对象，就把该对象放到集合中
	 * 
	 * @param criteria
	 * @param entity
	 * @param fields
	 * @param list
	 * @param prefix
	 */
	@Deprecated
	private void traversalfieldsDeprecated(Criteria criteria, IEnableEntity entity, Field[] fields,
			List<IEnableEntity> list, String prefix) {
		for (Field field : fields) {
			try {
				String fieldName = field.getName();
				Object fieldValue = Reflections.invokeGetter(entity, fieldName);
				if (fieldValue == null) {
					continue;
				}
				if (fieldValue instanceof IEnableEntity) {
					list.add((IEnableEntity) fieldValue);
					continue;
				}

				if (!StringUtils.isEmpty(String.valueOf(fieldValue))) {
					System.out.println(entity.getClass().getSimpleName() + ":" + fieldName + ">>>>>>" + fieldValue);
					Criterion c = Restrictions.eq(fieldName, fieldValue);
					criteria.add(c);
				}
			} catch (IllegalArgumentException e) {
				// 允许找不到get方法
			}
		}
	}
}