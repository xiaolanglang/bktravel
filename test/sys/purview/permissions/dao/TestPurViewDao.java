package sys.purview.permissions.dao;

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

import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.authority.dao.CPermissionsDao;
import com.bkweb.sys.authority.entity.Permissions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestPurViewDao {

	@Autowired
	private CPermissionsDao permissionsDao;

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
		List<Permissions> list = permissionsDao.getPermissionsByAccount(new Account("123"));
		System.out.println(">>>>" + list.size());
	}

}
