package test;

import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;

import com.bkweb.modules.position.entity.Continent;
import com.bkweb.sys.user.dao.UserDao;
import com.bkweb.sys.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestEhCache {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDao userDao;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	// 开启了二级缓存和查询缓存。用query.list()查询实体
	@Test
	public void testCache_query_list() {
		Session session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		// session.createQuery("from BkUser").setCacheable(true).list();
		session.createCriteria(Continent.class).setCacheable(true).list();

		session.getTransaction().commit();
		session.close();

		System.out.println("----------------------------------------------------");

		session = sessionFactory.openSession();
		session.beginTransaction();
		// session.createQuery("from BkUser").setCacheable(true).list();
		session.createCriteria(Continent.class).setCacheable(true).list();

		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 测试失败，没有想要的结果，测试作废
	 */
	@Test
	@Rollback(false)
	public void test_cache() {
		Session session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("from BkUser").setCacheable(true).list();

		session.getTransaction().commit();
		session.close();

		System.out.println("----------------------------------------------------");

		session = sessionFactory.openSession();
		session.beginTransaction();
		User bkUser = new User();
		bkUser.setAge(20);
		bkUser.setCard("211212121212");
		bkUser.setName("user");
		bkUser.setSex("男");
		userDao.save(bkUser);
		System.out.println(bkUser.getId());

		session.flush();
		session.getTransaction().commit();
		session.close();

		System.out.println("----------------------------------------------------");

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("from BkUser").setCacheable(true).list();

		session.getTransaction().commit();
		session.close();

		System.out.println("----------------------------------------------------end");

	}

}
