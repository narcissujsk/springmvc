package jsk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import jsk.service.UserService;
import jsk.vo.User;

@Scope("prototype")
@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	//
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "userid") String userid) {
		UserService service=new UserService();
		User user = service.getUserByID(userid);
		logger.info("getUser userid:" + userid);
		System.out.println("getUser userid:" +userid+"");
		Gson gson = new Gson();
		String entity = gson.toJson(user);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}



}
