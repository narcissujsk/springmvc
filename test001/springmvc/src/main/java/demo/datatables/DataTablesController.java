package demo.datatables;

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
@RequestMapping("/datatables")
public class DataTablesController {

	private static final Logger logger = LoggerFactory.getLogger(DataTablesController.class);

	@RequestMapping(value = "/{jspname}", method = RequestMethod.GET)
	public String get(@PathVariable(value = "jspname") String jspname,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Gson gson = new Gson();
		
		model.addAttribute("serverTime", formattedDate );
	
		return "datatables/"+jspname;
	}

}
