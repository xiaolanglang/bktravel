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

import com.bktravel.modules.user.dao.BkUserDao;
import com.bktravel.modules.user.entity.BkUser;
import com.bktravel.sys.account.dao.BkAccountDao;
import com.bktravel.sys.account.entity.BkAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestHibernateWithSpring {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	private BkAccountDao accountDao;

	@Autowired
	private BkUserDao userDao;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:confi/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
		session = sessionFactory.getCurrentSession();
	}

	@Test
	public void testUser_session_get() {
		BkUser bkUser = (BkUser) session.get(BkUser.class, "8aba95525059d394015059d395110000");
		System.out.println(bkUser);
	}

	@Test
	@Rollback(false)
	public void add() {

		for (int i = 500000, j = 6; i < 1500000; i++) {

			BkAccount account = new BkAccount();
			account.setUsername(String.valueOf(i));
			account.setPassword(String.valueOf(i));
			session.save(account);
			if (i == j * 100000) {
				System.out.println("????");
				session.flush();
				session.clear();
				j++;
			}
			// account.setId(null);
		}
	}

}
