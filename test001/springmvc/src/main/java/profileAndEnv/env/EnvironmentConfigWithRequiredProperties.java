package profileAndEnv.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import bean.vo.Boy;

@Configuration
public class EnvironmentConfigWithRequiredProperties {

  @Autowired
  Environment env;
  
  @Bean
  public Boy blankDisc() {
    return new Boy(
        env.getRequiredProperty("id"),
        env.getRequiredProperty("name"));
  }
  
}
