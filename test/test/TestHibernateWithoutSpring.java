package test;

import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.user.entity.User;

/**
 * 由于hibernatesessionfactory删除，本测试单元作废
 * 
 * @author Administrator
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate.cfg.xml" })
public class TestHibernateWithoutSpring {
	private Session session;
	Transaction transaction;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:conf/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
		// session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void after() {
		transaction.commit();
		session.flush();
		session.close();
	}

	@Test
	public void testAccount() {
		Account account = new Account();
		account.setUsername("1");
		account.setPassword("123");
		session.save(account);
	}

	@Test
	public void testUser_save() {
		User bkUser = new User();
		Account account = new Account();
		account.setUsername("111");
		account.setPassword("111");
		account.setId("8aba95525059c9a1015059c9a2530000");
		bkUser.setAccount(account);
		bkUser.setAge(20);
		bkUser.setBirthday(new Date());
		bkUser.setCard("211212121212");
		bkUser.setName("user");
		bkUser.setSex("男");

		session.save(bkUser);
	}

	@Test
	public void testUser_get() {
		User bkUser = (User) session.get(User.class, "8aba95525059d394015059d395110000");
		System.out.println(bkUser);
	}

}
