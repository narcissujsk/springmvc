package task;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.springInAction.aop.AopConfigTest;



public class SpringTaskTest {


	private static final Logger logger = LoggerFactory.getLogger(AopConfigTest.class);
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new ClassPathXmlApplicationContext("task/task.xml");
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
	public void test() throws Exception {
		
		logger.info("start");
		MyTask obj = (MyTask) context.getBean("task");
		MyTask obj2 = (MyTask) context.getBean("task");
		MyTask obj3 = (MyTask) context.getBean("task");
		Thread.sleep(10000);
		logger.info("end");
	}
	

}
