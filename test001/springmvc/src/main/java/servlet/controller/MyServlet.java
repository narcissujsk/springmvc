package servlet.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import servlet.service.MyServletService;

@Scope("prototype")
@Controller
@RequestMapping("/servlet")
public class MyServlet {
	private static final Logger logger = LoggerFactory.getLogger(MyServlet.class);
	
	/**
	 * ServletContext 获取值
	 * @param request
	 * @param response
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/attributes/{key}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getAttribute(HttpServletRequest request, HttpServletResponse response,@PathVariable(value = "key") String key) {
		MyServletService service= new MyServletService();
		Object value = service.getAttribute(key);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		logger.info(map+"");
		Gson gson = new Gson();
		String entity =gson.toJson(map);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	/**
	 * ServletContext 设置值
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/attributes", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> setAttribute(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
		MyServletService service= new MyServletService();
		logger.info(param+""+param);
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = param.keySet();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			String value = param.getString(key);
			map.put(key, value);
			
		}
		service.setAttribute(map);
		logger.info(map+"");
		Gson gson = new Gson();
		String entity =gson.toJson(map);
		ResponseEntity<String> re = new ResponseEntity<String>(entity, null, HttpStatus.ACCEPTED);
		return re;
	}
	
	  // WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()); 
}
