package jsk.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	//private static final Logger logger = LoggerFactory.getLogger(User.class);
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		Logger logger = LoggerFactory.getLogger(User.class);
		logger.info(toString()+" hashCode:"+hashCode());
		logger.info("");
		return id;
	}
//
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public int hashCode() {
		return super.hashCode();
	}

	public void init() {
		//System.out.println(this.getClass()+"Bean is going through init.");
	}

	public void destroy() {
	//	System.out.println(this.getClass()+"Bean will destroy now.");
	}

}
