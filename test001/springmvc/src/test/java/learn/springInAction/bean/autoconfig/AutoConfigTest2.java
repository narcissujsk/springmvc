package learn.springInAction.bean.autoconfig;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import learn.springInAction.bean.vo.SmallCar;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfig.class)
public class AutoConfigTest2 {

	@Rule  
	public final SystemOutRule log = new SystemOutRule().enableLog(); 
	@Autowired
	private SmallCar smallcar1;

	@Test
	public void carShouldNotBeNull() {
		assertNotNull(smallcar1);
		
		smallcar1.run();
		assertEquals(
		        "SmallCar run\r\n", 
		        log.getLog());
		
		
	}

}
