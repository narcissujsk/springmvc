package bean.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boy")
public class Boy implements People {

	private Car car;

	@Override
	public void say() {
		System.out.println("Boy say");
	}

	public void run() {
		System.out.println("Boy run car");
		if (car == null) {
			System.out.println("no car");
		} else {
			car.run();
		}
	}

	public Car getCar() {
		return car;
	}

	@Autowired(required = false)
	public void setCar(Car car) {
		this.car = car;
	}

}
