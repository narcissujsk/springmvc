package service;

import org.springframework.stereotype.Service;

import vo.User;
@Service
public class UserService {
	
	public User getUserByID(String id) {
		User user=new User();
		user.setId(id);
		return user;
		
	}

}
