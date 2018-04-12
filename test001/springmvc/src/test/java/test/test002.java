package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jsk.dao.UserDao;
import jsk.vo.User;

public class test002 {
	private static final Logger logger = LoggerFactory.getLogger(test002.class);
	
	@Test
	public void test() {
		UserDao dao=new UserDao();
		List<User> list = dao.getUsers();
		logger.info(list+"");
	}

}
