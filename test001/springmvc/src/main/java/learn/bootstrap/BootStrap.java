package learn.bootstrap;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope("prototype")
@Controller
@RequestMapping("/bootstrap")
public class BootStrap {
	private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String cout(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/bootstrap";
	}
	@RequestMapping(value = "/b1", method = RequestMethod.GET)
	public String b1(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/b1";
	}
	@RequestMapping(value = "/b2", method = RequestMethod.GET)
	public String b2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/b2";
	}
	@RequestMapping(value = "/b3", method = RequestMethod.GET)
	public String b3(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/b3";
	}
	@RequestMapping(value = "/b4", method = RequestMethod.GET)
	public String b4(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/b4";
	}
	@RequestMapping(value = "/b5", method = RequestMethod.GET)
	public String b5(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", formattedDate);
	
		return "bootstrap/b5";
	}
}
