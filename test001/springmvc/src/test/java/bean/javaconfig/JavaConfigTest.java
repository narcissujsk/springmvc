package bean.javaconfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import bean.vo.Boy;
import bean.vo.Car;

public class JavaConfigTest {
	private static final Logger logger = LoggerFactory.getLogger(JavaConfigTest.class);
	private AbstractApplicationContext context;

/*	@Before
	public void before() {
		 context = new FileSystemXmlApplicationContext(
					"src/main/webapp/WEB-INF/spring/student.xml");
	}*/
	@Before
	public void before() {
		 context = new AnnotationConfigApplicationContext(JavaConfig.class);
	}

	@After
	public void after() {
		context.close();
	}

	
	@Test
	public void getClassPath() {
		logger.info("fff");
		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}
	

	@Test
	public void getCar() {
		Car obj = (Car) context.getBean("smallcar");
		obj.run();
		System.out.println(obj);
	}
	@Test
	public void getBoy() {
		Boy obj = (Boy) context.getBean("boy");
		obj.run();
		System.out.println(obj);
	}
}
