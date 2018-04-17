package servlet.service;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class MyServletService {

	private ServletContext servletContext;

	public MyServletService() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		servletContext = webApplicationContext.getServletContext();
	}

	public boolean setAttribute(Map<String, Object> map) {
		String key;
		Object value;
		boolean isSuccess = false;
		if(map!=null&&map.size()>0) {
			for (Entry<String, Object> entry : map.entrySet()) {
				key=entry.getKey();
				value=entry.getValue();
				servletContext.setAttribute(key, value);
			}
			isSuccess=true;
		}else {
			isSuccess=false;
		}	
		return isSuccess;
	}

	public Object getAttribute(String key) {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		Object re = servletContext.getAttribute(key);
		return re;
	}

}
