package jsk.service;
import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.stereotype.Service;

import jsk.vo.User;
@Service
public class UserService {
	
	@Autowired
	private User user1;
	
	public User getUserByID(String id) {
		System.out.println(user1);
		User user=new User();
		user.setId(id);
		return user;
		
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

}
