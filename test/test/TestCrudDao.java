package test;

import java.io.FileNotFoundException;
import java.util.Date;

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
import com.bkweb.sys.account.dao.AccountDao;
import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.user.dao.UserDao;
import com.bkweb.sys.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestCrudDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AccountDao accountDao;

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

	@Test
	@Rollback(false)
	public void save() {
		User bkUser = new User();
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
		User bkUser = new User();
		bkUser.setId("8aba95525059d394015059d395110000");
		userDao.get(bkUser);
	}

	@Test
	public void getUpdateGet() {
		User bkUser = new User();
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
		HPage<Account> page = new HPage<Account>(1);
		accountDao.findPageList(new Account(), true, page);
		accountDao.findPageList(new Account(), true, page);
		System.out.println(page);
	}

	@Test
	@Rollback(false)
	public void del() {
		User bkUser = new User();
		bkUser.setId("8aba9552506430d601506430d89f0000");
		userDao.delete(bkUser);
	}

	@Test
	@Rollback(false)
	public void update() {
		User bkUser = new User();
		bkUser.setCard("12");
		bkUser.setId("8aba95525059d394015059d395110000");
		userDao.update(bkUser);
	}

	@Test
	@Rollback(false)
	public void dynamicUpdate() {
		Account account = new Account();
		account.setId("123");
		User user = new User();
		user.setName("kkkk");
		user.setId("8aba9552511d73fb01511d73febd0000");
		user.setAccount(account);
		userDao.update(user);
	}

}
