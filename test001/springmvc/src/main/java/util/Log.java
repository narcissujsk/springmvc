package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);
	
	public static void info(Object msg) {
		logger.info(msg+"");
	}
	public static void error(Object msg) {
		logger.error(msg+"");
	}
}
