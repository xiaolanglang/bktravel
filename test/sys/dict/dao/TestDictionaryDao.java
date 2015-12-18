package sys.dict.dao;

import java.io.FileNotFoundException;
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

import com.bkweb.sys.dict.dao.BkDictionaryDao;
import com.bkweb.sys.dict.entity.Dictionary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-*.xml" })
@Transactional
public class TestDictionaryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BkDictionaryDao dictionaryDao;

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
	public void getMaxType() {
		Dictionary dictionary = new Dictionary();
		dictionary.setType("travel_theme");
		int value = dictionaryDao.getMaxType(dictionary);
		System.out.println(value);
	}

	@Test
	@Rollback(false)
	public void update() {
	}

	@Test
	@Rollback(false)
	public void types() {
		List<String> list = dictionaryDao.findAllTypes();
		System.out.println(list);
	}

}
