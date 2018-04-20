package learn.springInAction.profileAndEnv.env;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import learn.springInAction.bean.vo.Boy;



public class EnvironmentInjectionTest {

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfig.class)
  public static class InjectFromProperties {
  
    @Autowired
    private Boy boy;
    
    @Test
    public void assertBlankDiscProperties() {
    	System.out.println(boy);
      assertEquals("id", boy.getId());
      assertEquals("name", boy.getName());
    }
    
  }
  
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfigWithDefaults.class)
  public static class InjectFromPropertiesWithDefaultValues {
  
    @Autowired
    private Boy boy;
    
    @Test
    public void assertBlankDiscProperties() {
    	assertEquals("id", boy.getId());
        assertEquals("name", boy.getName());
    }
    
  }

  public static class InjectFromPropertiesWithRequiredProperties {
  
    @Test(expected=BeanCreationException.class)
    public void assertBlankDiscProperties() {
      new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
    }
    
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration("classpath:profileAndEnv/env/placeholder-config.xml")
  public static class InjectFromProperties_XMLConfig {
  
    @Autowired
    private Boy boy;
    
    @Test
    public void assertBlankDiscProperties() {
    	assertEquals("id", boy.getId());
        assertEquals("name", boy.getName());
    }
    
  }

}