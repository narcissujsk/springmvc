package profileAndEnv.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import bean.vo.Boy;

@Configuration
@PropertySource("classpath:properties/my.properties")
public class EnvironmentConfig {

  @Autowired
  Environment env;
  
  @Bean
  public Boy blankDisc() {
    return new Boy(
        env.getProperty("id"),
        env.getProperty("name"));
  }
  
}
