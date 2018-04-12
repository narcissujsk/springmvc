package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import controller.fileUpload;
import vo.User;

public class test001 {
	private static final Logger logger = LoggerFactory.getLogger(test001.class);
	@Test
	public void test() {
		System.out.println("fff");
		logger.info("ffff");
	}

	@Test
	public void test002() {
		System.out.println("fff");
		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}

	@Test
	public void beanTeat001() {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User obj = (User) context.getBean("user1");
		obj.getMessage();
		obj = context.getBean(User.class);
		obj.getMessage();

	}

	@Test
	public void beanTeat002() {

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/spring/contextConfigLocation.xml");
		User obj = (User) context.getBean("user1");
		obj.getMessage();
		obj = context.getBean(User.class);
		obj.getMessage();
		boolean gg = context.isSingleton("user1");
		System.out.println(gg);
	}
}
