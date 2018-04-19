package aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
public class Log {
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
		logger.info("Log from aop is ready to work ");
	}
	
	@AfterReturning("log()")
	public void afterLog() {
		logger.info("Log from aop work done ");
	}
}
