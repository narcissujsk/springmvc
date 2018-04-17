package jsk.vo;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.google.gson.Gson;

public class StudentTest implements InitializingBean,DisposableBean ,BeanNameAware,BeanFactoryAware,ApplicationContextAware,BeanPostProcessor{
	private static final Logger logger = LoggerFactory.getLogger(StudentTest.class);
	private String studentid;
	private String studentname;
	private BeanFactory beanFactory;
	private String beanName;
	private ApplicationContext applicationContext;
	@Override
	public String toString() {
		Gson gson=new Gson();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("studentid", studentid);
		map.put("studentname", studentname);
		map.put("beanFactory", beanFactory.toString());
		map.put("beanName", beanName);
		map.put("applicationContext", applicationContext.toString());
		String str = gson.toJson(map);
		return str;
	}
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentid() {
		return studentid;
	}
//
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//logger.info(this.getClass()+" afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		//logger.info(this.getClass()+" destroy");
		
	}

	@Override
	public void setBeanName(String name) {
		beanName=name;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.info("setBeanFactory  beanFactory:"+beanFactory);
		this.beanFactory=beanFactory;
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info("setApplicationContext  applicationContext:"+applicationContext);
		this.applicationContext=applicationContext;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("postProcessBeforeInitialization  bean:"+bean+"   beanName:"+beanName+"");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("postProcessAfterInitialization  bean:"+bean+"   beanName:"+beanName+"");
		return null;
	}

	
	
	
}
