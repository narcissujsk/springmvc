package bean.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boy")
public class Boy implements People {
	//@Autowired
	private Car car;

	public Boy(Car car) {
		this.car = car;
	}

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

	public void setCar(Car car) {
		this.car = car;
	}

}
