package test001.service;

import org.springframework.stereotype.Service;

import test001.vo.User;
@Service
public class UserService {
	
	public User getUserByID(String id) {
		User user=new User();
		user.setId(id);
		return user;
		
	}

}
