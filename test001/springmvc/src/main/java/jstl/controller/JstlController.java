package jstl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import jsk.service.UserService;
import jsk.vo.User;

@Scope("prototype")
@Controller
@RequestMapping("/jstl")
public class JstlController {
	@Autowired
	private UserService service;
	private static final Logger logger = LoggerFactory.getLogger(JstlController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cout", method = RequestMethod.GET)
	public String cout(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		List<User> users = service.getUsers();
		logger.info("getUsers" + users);
		Gson gson = new Gson();
		String userlist = gson.toJson(users);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("userlist", userlist);
		return "jstl/cout";
	}

	@RequestMapping(value = "/cset", method = RequestMethod.GET)
	public String cset(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		List<User> users = service.getUsers();
		logger.info("getUsers" + users);
		Gson gson = new Gson();
		String userlist = gson.toJson(users);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("userlist", userlist);
		model.addAttribute("user", users.get(0));
		model.addAttribute("user2", users);
		return "jstl/cset";
	}

	@RequestMapping(value = "/ccatch", method = RequestMethod.GET)
	public String ccatch(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "jstl/ccatch";
	}

	@RequestMapping(value = "/cif", method = RequestMethod.GET)
	public String cif(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "jstl/cif";
	}

	@RequestMapping(value = "/cchoose", method = RequestMethod.GET)
	public String cchoose(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "jstl/cchoose";
	}

	@RequestMapping(value = "/cforeach", method = RequestMethod.GET)
	public String cforeach(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		List<User> users = service.getUsers();
		logger.info("getUsers" + users);
		Gson gson = new Gson();
		String userlist = gson.toJson(users);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("userlist", userlist);
		model.addAttribute("user", users.get(0));
		model.addAttribute("users", users);
		return "jstl/cforeach";
	}

	@RequestMapping(value = "/curl", method = RequestMethod.GET)
	public String curl(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "jstl/curl";
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
