package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import jsk.vo.User;

public class UserTest {
	private static final Logger logger = LoggerFactory.getLogger(UserTest.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new ClassPathXmlApplicationContext("xml/user.xml");
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

		
		User obj = (User) context.getBean("userTest");
		obj.getMessage();
		obj = context.getBean(User.class);
		obj.getMessage();
		boolean gg = context.isSingleton("userTest");
		System.out.println(gg);
	}
}
