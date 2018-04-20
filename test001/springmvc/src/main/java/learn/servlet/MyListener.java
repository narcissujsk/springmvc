package learn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent event) {
        System.out.println("*************destroy ContextListener*************");
    }

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("*************init ContextListener*************");
        ServletContext servletContext = event.getServletContext();
        System.out.println("key:"+servletContext.getInitParameter("key"));
    }

}
