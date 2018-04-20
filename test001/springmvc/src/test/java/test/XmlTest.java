package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import jsk.dao.UserDao;
import jsk.vo.User;



public class XmlTest {
	private static final Logger logger = LoggerFactory.getLogger(XmlTest.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/contextConfigLocation.xml");
	}

	@After
	public void after() {
		context.close();
	}

	@Test
	public void test() {
		System.out.println("fff");
		logger.info("ffff");
	}
	@Test
	public void getClassPpath() {
		System.out.println("fff");
		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}
	

	@Test
	public void getUserBeanByID() {

		
		UserDao obj = (UserDao) context.getBean("userdao");
		System.out.println(obj.getUsers());
		boolean gg = context.isSingleton("userdao");
		System.out.println(gg);
	}
}
