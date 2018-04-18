package bean.mixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import bean.javaconfig.JavaConfig;

@Configuration
@Import(JavaConfig.class)
@ImportResource("classpath:bean/xmlconfig/xmlConfig.xml")
public class MixedConfig {

}
