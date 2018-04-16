package jsk.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.stereotype.Service;

import jsk.dao.UserDao;
import jsk.vo.User;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	public User getUserByID(String id) {
		logger.info(id);
		User user = new User();
		user.setId(id);
		return user;

	}

	public List<User> getUsers() {	
		List<User> list = userDao.getUsers();
		return list;

	}

	

}
