package jsk.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.stereotype.Service;

import jsk.controller.UserController;
import jsk.dao.UserDao;
import jsk.vo.User;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private User user1;
	@Autowired
	private UserDao userDao1;

	public User getUserByID(String id) {
		logger.info(id);
		User user = new User();
		user.setId(id);
		return user;

	}

	public List<User> getUsers() {
		logger.info(user1+"");
		logger.info(userDao1+"");
		List<User> list = userDao1.getUsers();
		return list;

	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public UserDao getUserDao1() {
		return userDao1;
	}

	public void setUserDao1(UserDao userDao) {
		this.userDao1 = userDao;
	}

}
