package learn.springInAction.profileAndEnv.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import learn.springInAction.bean.vo.Boy;



@Configuration
public class EnvironmentConfigWithDefaults {

  @Autowired
  Environment env;
  
  @Bean
  public Boy blankDisc() {
    return new Boy(
        env.getProperty("id", "id"),
        env.getProperty("name", "name"));
  }
  
}
