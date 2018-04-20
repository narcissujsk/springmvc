package learn.springInAction.bean.javaconfig;

import org.springframework.context.annotation.Bean;

import learn.springInAction.bean.vo.Boy;
import learn.springInAction.bean.vo.Car;
import learn.springInAction.bean.vo.SmallCar;


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
