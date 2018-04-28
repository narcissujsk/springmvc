package jsk.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired
	private UserService service;
	//
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{userid:.+}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "userid") String userid) {
		
		User user = service.getUserByID(userid);
		logger.info("getUser userid:" + userid);
		System.out.println("getUser userid:" +userid+"");
		Gson gson = new Gson();
		String entity = gson.toJson(user);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	
	@RequestMapping(value = "/{userid}.com", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getUser2(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "userid") String userid) {
		
		User user = service.getUserByID(userid);
		logger.info("getUser userid:" + userid);
		System.out.println("getUser userid:" +userid+"");
		Gson gson = new Gson();
		user.setId(userid+".com");
		String entity = gson.toJson(user);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getUsers(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> users = service.getUsers();
		logger.info("getUsers"+users);	
		Gson gson = new Gson();
		String entity = gson.toJson(users);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getUsersByPost(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> users = service.getUsers();
		logger.info("getUsers"+users);	
		Gson gson = new Gson();
		String entity = gson.toJson(users);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String userlist(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		List<User> users = service.getUsers();
		logger.info("getUsers"+users);	
		Gson gson = new Gson();
		String userlist = gson.toJson(users);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userlist", userlist );
		model.addAttribute("users", users );
		return "userlist";
	}

}
