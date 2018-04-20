package aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 发送消息的切面
 * @author jiangsk
 *
 */
@Aspect
public class MessageAspect {
	private static final Logger logger = LoggerFactory.getLogger(MessageAspect.class);

	@DeclareParents(value = "aop.User+",defaultImpl=Message.class)
	public static MessageInterface mess;
}
