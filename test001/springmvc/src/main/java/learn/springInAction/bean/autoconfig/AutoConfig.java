package learn.springInAction.bean.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"learn.springInAction.bean"})
public class AutoConfig{

}

/*@Configuration
@ComponentScan(basePackages= {"bean"})
public class AutoConfig{

}*/
