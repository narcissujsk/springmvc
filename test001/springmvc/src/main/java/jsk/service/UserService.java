package jsk.service;
//
import org.springframework.stereotype.Service;

import jsk.vo.User;
@Service
public class UserService {
	
	public User getUserByID(String id) {
		User user=new User();
		user.setId(id);
		return user;
		
	}

}
