package jsk.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(Student.class);
	private String studentid;

	private String studentname;

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
		logger.info(this.getClass()+" afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		logger.info(this.getClass()+" destroy");
		
	}
}
