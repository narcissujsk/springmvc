package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import util.Log;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan

public class AopConfig {
	
	@Bean("log")
	public Log log() {
		return new Log();
	}

}
