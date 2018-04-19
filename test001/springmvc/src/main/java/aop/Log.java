package aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Log {
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	@Pointcut("execution(* *.Log(int))&&args(id)")
	public void log(int id) {
	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void info(Object msg) {
		logger.info(msg + "");
	}

	public static void error(Object msg) {
		logger.error(msg + "");
	}

	@Before("log(id)")
	public void beforeLog(int id) {
		int time = getIdTimes(id);
		map.put(id, time+1);
		logger.info("Log from aop is ready to work id is " +id+" and times is" +time);
	}

	@AfterReturning("log(id)")
	public void afterLog(int id) {
		int time = getIdTimes(id);
		logger.info("Log from aop work id is" +id+" and times is" +time);
	}

	public int getIdTimes(Integer id) {
		return map.containsKey(id) ? map.get(id) : 0;
	}
}
