package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan

public class AopConfig {
	
	@Bean("log")
	public Log log() {
		return new Log();
	}

	@Bean("user")
	public User user() {
		return new User();
	}
}
