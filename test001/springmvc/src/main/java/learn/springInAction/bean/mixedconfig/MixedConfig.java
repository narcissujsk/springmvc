package learn.springInAction.bean.mixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import learn.springInAction.bean.javaconfig.JavaConfig;


@Configuration
@Import(JavaConfig.class)
@ImportResource("classpath:bean/xmlconfig/xmlConfig.xml")
public class MixedConfig {

}
