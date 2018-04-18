package bean.maxedconfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import bean.mixedconfig.MixedConfig;
import bean.vo.Boy;
import bean.vo.Car;

public class MixedConfigTest {
	private static final Logger logger = LoggerFactory.getLogger(MixedConfigTest.class);
	private AbstractApplicationContext context;

/*	@Before
	public void before() {
		 context = new FileSystemXmlApplicationContext(
					"src/main/webapp/WEB-INF/spring/student.xml");
	}*/
	@Before
	public void before() {
		 context = new AnnotationConfigApplicationContext(MixedConfig.class);
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
	public void car() {
		Car obj = (Car) context.getBean("smallcar");
		obj.run();

		System.out.println(obj);
	}
	@Test
	public void boy() {
		Boy obj = (Boy) context.getBean("boy");
		obj.run();

		System.out.println(obj);
	}
	@Test
	public void boy2() {
		Boy obj = (Boy) context.getBean("boy2");
		obj.run();

		System.out.println(obj);
	}
	@Test
	public void boy3() {
		Boy obj = (Boy) context.getBean("boy3");
		obj.run();

		System.out.println(obj);
	}
	
	@Test
	public void boy4() {
		Boy obj = (Boy) context.getBean("boy4");
		obj.run();

		System.out.println(obj.getName());
	}
	@Test
	public void boy5() {
		Boy obj = (Boy) context.getBean("boy5");
		obj.run();

		System.out.println(obj.getName());
	}
	
	@Test
	public void boy6() {
		Boy obj = (Boy) context.getBean("boy6");
		obj.run();

		System.out.println(obj.getName());
		System.out.println(obj.getRoles());
	}
	@Test
	public void boy7() {
		Boy obj = (Boy) context.getBean("boy7");
		obj.run();

		System.out.println(obj.getName());
		System.out.println(obj.getRoles());
		System.out.println(obj.getCars());
	}
	@Test
	public void boy8() {
		Boy obj = (Boy) context.getBean("boy8");
		obj.run();

		System.out.println(obj.getName());
		System.out.println(obj.getRoles());
		System.out.println(obj.getCars());
	}
}
