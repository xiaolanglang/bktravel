package test;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

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

import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.user.dao.BkUserDao;
import com.bkweb.modules.user.entity.BkUser;
import com.bkweb.modules.user.view.BkUserView;
import com.bkweb.sys.account.dao.BkAccountDao;
import com.bkweb.sys.account.entity.BkAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestCrudDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BkAccountDao accountDao;

	@Autowired
	private BkUserDao userDao;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	@Test
	@Rollback(false)
	public void save() {
		BkUser bkUser = new BkUser();
		bkUser.setAge(20);
		bkUser.setBirthday(new Date());
		bkUser.setCard("211212121212");
		bkUser.setName("user");
		bkUser.setSex("男");
		userDao.save(bkUser);
		System.out.println(bkUser.getId());
	}

	@Test
	public void get() {
		BkUser bkUser = new BkUser();
		bkUser.setId("8aba95525059d394015059d395110000");
		userDao.get(bkUser);
	}

	@Test
	public void getUpdateGet() {
		BkUser bkUser = new BkUser();
		bkUser.setId("8aba95525059d394015059d395110000");
		userDao.get(bkUser);
		bkUser.setAge(10);
		userDao.update(bkUser);
		bkUser = userDao.get(bkUser);
		System.out.println(bkUser.getAge());
	}

	@Test
	@Rollback(false)
	public void findList() {
		// userDao.findList(new BkUser(), false, "account");
		// userDao.test();
	}

	@Test
	public void findPageList() {
		HPage<BkAccount> page = new HPage<BkAccount>(1);
		accountDao.findPageList(new BkAccount(), true, page);
		accountDao.findPageList(new BkAccount(), true, page);
		System.out.println(page);
	}

	@Test
	@Rollback(false)
	public void del() {
		BkUser bkUser = new BkUser();
		bkUser.setId("8aba9552506430d601506430d89f0000");
		userDao.delete(bkUser);
	}

	@Test
	@Rollback(false)
	public void update() {
		BkUser bkUser = new BkUser();
		bkUser.setCard("12");
		bkUser.setId("8aba95525059d394015059d395110000");
		userDao.update(bkUser);
	}

	@Test
	@Rollback(false)
	public void dynamicUpdate() {
		BkAccount account=new BkAccount();
		account.setId("123");
		BkUser user = new BkUser();
		user.setName("kkkk");
		user.setId("8aba9552511d73fb01511d73febd0000");
		user.setAccount(account);
		userDao.update(user);
	}

	/**
	 * 该条测试由于map文件的改变，测试已经失效
	 */
	@Test
	public void sqlQuery() {
		List<BkUserView> list = (List<BkUserView>) userDao
				.sqlQueryList(
						"select a.name,a.id,a.sex,b.username,b.id from bk_userinfo a left join bk_account b on a.accountId = b.id",
						BkUserView.class, false);
		System.out.println(list.get(0));

	}

}
