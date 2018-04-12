package controller;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		Locale h = new Locale("en");
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, h);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		Locale h = new Locale("en");
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, h);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "upload";
	}

	@RequestMapping(value = "/doupload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file, Model model) throws Exception {

		System.out.println(description);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = "D:/";
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));
			Date date = new Date();
			Locale h = new Locale("en");
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, h);

			String formattedDate = dateFormat.format(date);

			model.addAttribute("serverTime", formattedDate);
			return "success";
		} else {
			return "error";
		}

	}
}
