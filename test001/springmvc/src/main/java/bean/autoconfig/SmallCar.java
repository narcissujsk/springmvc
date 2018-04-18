package bean.autoconfig;

import org.springframework.stereotype.Component;

@Component("smallcar")
public class SmallCar implements Car{

	@Override
	public void run() {
		System.out.println("SmallCar run");
		
	}

}
