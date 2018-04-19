package layer;

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

import jsk.controller.UserController;
@Scope("prototype")
@Controller
@RequestMapping("/layer")
public class LayerController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String layer(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate );
		return "layer/layer";
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demo(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate );
		return "layer/demo";
	}

}
