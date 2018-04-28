package demo.filter;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ---------------------------
 * Desc:   登录过滤器
 */
public class LoginFilter implements Filter,  HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 需要排除的页面
     */
    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void destroy() {
    	logger.debug(" invoke destroy, but don nothing...");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPages = filterConfig.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
        return;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath().substring(1);
        boolean exclude = false;
        for (String s : excludedPageArray) {
            if (servletPath.indexOf(s) != -1) {
                exclude = true;
                break;
            }
        }

        logger.info("login filter:" + request.getRequestURI() + "\t exclude:" + exclude);
        /*//如果判断是 AJAX 请求,直接设置为session超时
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            response.setHeader("sessionstatus", "timeout");
        }*/

        if (exclude) {
            if ((request.getRequestURI().equals(request.getContextPath()) || request.getRequestURI().equals(request.getContextPath() + "/"))
                    && session.getAttribute("SESSION_USER") != null){
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
            	response.sendRedirect(request.getContextPath() + "/login");
                filterChain.doFilter(request, response);
            }
            return;
        } else {
            if (null == session.getAttribute("SESSION_USER")) {
                response.sendRedirect(request.getContextPath());
                return;
            }
            filterChain.doFilter(request, response);
        }
    }
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		  logger.info("login filter preHandle:" + request.getRequestURI() );
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		  logger.info("login filter postHandle:" + request.getRequestURI());
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		  logger.info("login filter afterCompletion:" + request.getRequestURI());
		
	}
}
