package learn.springInAction.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan

public class AopConfig {
	
	@Bean("log")
	public LogAspect log() {
		return new LogAspect();
	}

	@Bean("user")
	public User user() {
		return new User();
	}
	
	@Bean("messageAspect")
	public MessageAspect messageAspect() {
		return new MessageAspect();
	}
}
