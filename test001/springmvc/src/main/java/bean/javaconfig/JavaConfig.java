package bean.javaconfig;

import org.springframework.context.annotation.Bean;

import bean.vo.Boy;
import bean.vo.Car;
import bean.vo.SmallCar;

public class JavaConfig {
	@Bean("smallcar")
	public Car getCar() {
		return new SmallCar();
	}
	@Bean("boy")
	public Boy getBoy(Car car) {
		return new Boy(car);
	}

}
