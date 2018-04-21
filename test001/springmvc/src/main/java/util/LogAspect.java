package util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);

	@Pointcut("execution(* *.*(..))")
	public void log() {
	}

	public static void info(Object msg) {
		logger.info(msg + "");
	}

	public static void error(Object msg) {
		logger.error(msg + "");
	}

	@Before("log()")
	public void beforeLog(JoinPoint point) {
		logger.info("Log is ready to work ");


		System.out.println("@Before：模拟权限检查...");

		System.out.println("@Before：目标方法为：" +

				point.getSignature().getDeclaringTypeName() +

				"." + point.getSignature().getName());

		System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));

		System.out.println("@Before：被织入的目标对象为：" + point.getTarget());

	
	}

	@AfterReturning("log()")
	public void afterLog() {
		logger.info("Log  work done ");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Around("execution(* com.abc.service.*.many*(..))")

	public Object process(ProceedingJoinPoint point) throws Throwable {

		System.out.println("@Around：执行目标方法之前...");

		// 访问目标方法的参数：

		Object[] args = point.getArgs();

		if (args != null && args.length > 0 && args[0].getClass() == String.class) {

			args[0] = "改变后的参数1";

		}

		// 用改变后的参数执行目标方法

		Object returnValue = point.proceed(args);

		System.out.println("@Around：执行目标方法之后...");

		System.out.println("@Around：被织入的目标对象为：" + point.getTarget());

		return "原返回值：" + returnValue + "，这是返回结果的后缀";

	}

	@Before("execution(* com.abc.service.*.many*(..))")

	public void permissionCheck(JoinPoint point) {

		System.out.println("@Before：模拟权限检查...");

		System.out.println("@Before：目标方法为：" +

				point.getSignature().getDeclaringTypeName() +

				"." + point.getSignature().getName());

		System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));

		System.out.println("@Before：被织入的目标对象为：" + point.getTarget());

	}

	@AfterReturning(pointcut = "execution(* com.abc.service.*.many*(..))",

			returning = "returnValue")

	public void log(JoinPoint point, Object returnValue) {

		System.out.println("@AfterReturning：模拟日志记录功能...");

		System.out.println("@AfterReturning：目标方法为：" +

				point.getSignature().getDeclaringTypeName() +

				"." + point.getSignature().getName());

		System.out.println("@AfterReturning：参数为：" +

				Arrays.toString(point.getArgs()));

		System.out.println("@AfterReturning：返回值为：" + returnValue);

		System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());

	}

	@After("execution(* com.abc.service.*.many*(..))")

	public void releaseResource(JoinPoint point) {

		System.out.println("@After：模拟释放资源...");

		System.out.println("@After：目标方法为：" +

				point.getSignature().getDeclaringTypeName() +

				"." + point.getSignature().getName());

		System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));

		System.out.println("@After：被织入的目标对象为：" + point.getTarget());

	}

}
