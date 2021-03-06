package learn.springInAction.bean.autoconfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import learn.*;
import learn.springInAction.bean.vo.Car;
import learn.springInAction.bean.vo.People;




public class AutoConfigTest {
	private static final Logger logger = LoggerFactory.getLogger(AutoConfigTest.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new AnnotationConfigApplicationContext(AutoConfig.class);
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
	public void beanCarTest() {
		Car obj = (Car) context.getBean("smallcar");
		obj.run();
		logger.info(obj+"");
	}
	@Test
	public void boyTest() {
		People obj = (People) context.getBean("boy");
		obj.run();
		logger.info(obj+"");
	}
}
