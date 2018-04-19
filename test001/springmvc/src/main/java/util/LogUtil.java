package util;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
public class LogUtil {
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);
	@Pointcut("execution(* *.Log(..))")
	public void log() {}
	
	public static void info(Object msg) {
		logger.info(msg+"");
	}
	public static void error(Object msg) {
		logger.error(msg+"");
	}
	
	@Before("log()")
	public void beforeLog() {
		logger.info("Log is ready to work ");
	}
	
	@AfterReturning("log()")
	public void afterLog() {
		logger.info("Log  work done ");
	}
}
