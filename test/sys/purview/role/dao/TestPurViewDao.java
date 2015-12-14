package sys.purview.role.dao;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;

import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.authority.dao.RoleDao;
import com.bktravel.sys.authority.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestPurViewDao {

	@Autowired
	private RoleDao roleDao;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	@Test
	public void find() {
		List<Role> list = roleDao.findRoleListByAccount(new Account("123"));
		System.out.println(">>>>" + list.size());
	}

}
