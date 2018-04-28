package jsk.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//
/**
 * Handles requests for the application home page.
 */
@Controller
public class FileMgr {

	private static final Logger logger = LoggerFactory.getLogger(FileMgr.class);

	

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
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, Model model) {
		Locale h = new Locale("en");
		List<String> files=new ArrayList<String>();
		String path = request.getSession().getServletContext().getRealPath("/resources/image/");
		 File dir = new File(path);
		 File[] list = dir.listFiles();
		 for (File file : list) {
			 files.add(file.getName()+"");
		}
		model.addAttribute("filename", files.get(0));

		return "download";
	}

	@RequestMapping(value = "/doupload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file, Model model) throws Exception {

		System.out.println(description);
		String path = request.getSession().getServletContext().getRealPath("/");
		logger.info(path);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			// String path = "D:/jsk";
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

	@RequestMapping(value = "/dodownload")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename, Model model)
			throws Exception {
		// 下载文件路径
		String path = request.getSession().getServletContext().getRealPath("/resources/image/");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);
	}
}
