package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import jsk.service.UserService;
import jsk.vo.Student;
import jsk.vo.User;

public class test001 {
	private static final Logger logger = LoggerFactory.getLogger(test001.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new FileSystemXmlApplicationContext(
					"src/main/webapp/WEB-INF/spring/contextConfigLocation.xml");
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
	public void test002() {
		System.out.println("fff");
		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}
	@Test
	public void testAuto() {
		UserService service=new UserService();
		service.getUser1().getMessage();
	}
	@Test
	public void testautowire() {
		UserService service = (UserService) context.getBean("service");
		service.getUser1().getMessage();
	}
	@Test
	public void beanTeat001() {

		User obj = (User) context.getBean("user1");
		obj.getMessage();
		obj = context.getBean(User.class);
		obj.getMessage();

	}

	@Test
	public void beanTeat002() {

		
		User obj = (User) context.getBean("user1");
		obj.getMessage();
		obj = context.getBean(User.class);
		obj.getMessage();
		boolean gg = context.isSingleton("user1");
		System.out.println(gg);
	}

	@Test
	public void beanStudentTeat002() {
		Student obj = (Student) context.getBean("student1");
		logger.info(obj.hashCode() + "");
		Student obj2 = context.getBean(Student.class);
		logger.info(obj2.hashCode() + "");
		boolean gg = context.isSingleton("student1");
	
		System.out.println(gg);
	}
}
