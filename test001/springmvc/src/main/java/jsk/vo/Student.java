package jsk.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student{
	private static final Logger logger = LoggerFactory.getLogger(Student.class);
	private String studentid;
	private String studentname;
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	
	
}
