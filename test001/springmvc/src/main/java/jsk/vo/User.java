package jsk.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	//private static final Logger logger = LoggerFactory.getLogger(User.class);
	@JsonProperty(value = "user_id")
	private String id;
	@JsonProperty(value = "user_name")
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
	@JsonIgnore
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
		System.out.println(this.getClass()+"Bean is going through init.");
	}

	public void destroy() {
		System.out.println(this.getClass()+"Bean will destroy now.");
	}

}
