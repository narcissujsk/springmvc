package bean.javaconfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jsk.vo.StudentTest;

public class StudentTestJUnit {
	private static final Logger logger = LoggerFactory.getLogger(StudentTestJUnit.class);
	private AbstractApplicationContext context;

/*	@Before
	public void before() {
		 context = new FileSystemXmlApplicationContext(
					"src/main/webapp/WEB-INF/spring/student.xml");
	}*/
	@Before
	public void before() {
		 context = new ClassPathXmlApplicationContext("xml/student.xml");
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
	public void beanStudentTeat() {
		StudentTest obj = (StudentTest) context.getBean("studentTest");
		//logger.info(obj.hashCode() + "");
		//Student obj2 = context.getBean(Student.class);
		//logger.info(obj2.hashCode() + "");
		boolean gg = context.isSingleton("studentTest");
	
		System.out.println(obj);
	}
}
