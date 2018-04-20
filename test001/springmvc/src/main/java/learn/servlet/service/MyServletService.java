package learn.servlet.service;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class MyServletService {

	private ServletContext servletContext;
	
	/*
	 * public MyServletService() { WebApplicationContext webApplicationContext =
	 * ContextLoader.getCurrentWebApplicationContext(); servletContext =
	 * webApplicationContext.getServletContext(); }
	 */
	public MyServletService() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		servletContext = webApplicationContext.getServletContext();
	}

	public MyServletService(ServletContext Context) {
		servletContext = Context;
	}

	public WebApplicationContext getWebApplicationContext() {
		WebApplicationContext webApplicationContext = (WebApplicationContext) servletContext
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		return webApplicationContext;
	}

	public boolean setAttribute(Map<String, Object> map) {
		String key;
		Object value;
		boolean isSuccess = false;
		if (map != null && map.size() > 0) {
			for (Entry<String, Object> entry : map.entrySet()) {
				key = entry.getKey();
				value = entry.getValue();
				servletContext.setAttribute(key, value);
			}
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		return isSuccess;
	}

	public Object getAttribute(String key) {
		Object re = servletContext.getAttribute(key);
		return re;
	}

}
