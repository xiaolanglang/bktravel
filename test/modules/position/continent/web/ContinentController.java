package modules.position.continent.web;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.context.WebApplicationContext;

import common.MyHandle;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebRoot")
@ContextConfiguration(locations = { "classpath:config/spring*.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ContinentController {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	// @Rollback(false)
	public void list() throws Exception {
		String requestBody = "{\"pageNum\":\"1\"}";
		String path = "/admin/continent/list";
		this.mockMvc.perform(MockMvcRequestBuilders.post(path).contentType(MediaType.ALL).content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MyHandle.print());

	}

}
