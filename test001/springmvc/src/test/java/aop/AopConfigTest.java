package aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import bean.vo.Car;
import bean.vo.People;

public class AopConfigTest {
	private static final Logger logger = LoggerFactory.getLogger(AopConfigTest.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new AnnotationConfigApplicationContext(AopConfig.class);
	}

	@After
	public void after() {
		context.close();
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
	public void aopTest() {
		User obj = (User) context.getBean("user");
		obj.Log();;
		logger.info(obj+"");
	}
	
}
