package learn.springInAction.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import learn.springInAction.spittr.web.WebConfig;



public class SpitterWebInitializer //extends AbstractAnnotationConfigDispatcherServletInitializer
{
  
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}