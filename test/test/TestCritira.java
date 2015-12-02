package test;

import java.io.FileNotFoundException;

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

import com.bkweb.modules.position.dao.ProvinceDao;
import com.bkweb.modules.position.entity.Continent;
import com.bkweb.modules.position.entity.Nation;
import com.bkweb.modules.position.entity.Province;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestCritira {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProvinceDao provinceDao;

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
	public void test() {

		// provinceDao.findList(province, true, "nation", "continent");

		// provinceDao.test();
		Continent continent = new Continent();
		Nation nation = new Nation();
		Province province = new Province();
		nation.setContinent(continent);
		province.setNation(nation);
		provinceDao.findList(province, true, "nation", "nation.continent");

	}
}
