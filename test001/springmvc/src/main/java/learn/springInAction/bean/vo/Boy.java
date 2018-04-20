package learn.springInAction.bean.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boy")
public class Boy implements People {
	//@Autowired
	private Car car;
	private String name;
	private List <String>roles;
	private List <Car> cars;
	private String id;
	public Boy(Car car) {
		this.car = car;
	}
	public Boy(Car car,String name) {
		this.car = car;
		this.setName(name);
	}
	public Boy(String id,String name) {
		this.setId(id);
		this.setName(name);
	}
	public Boy(Car car,String name,List<String> roles,List<Car> cars) {
		this.car = car;
		this.cars = cars;
		this.setName(name);
	}
	public Boy(Car car,String name,List<String> roles) {
		this.car = car;
		this.setRoles(roles);
		this.setName(name);
	}
	public Boy() {
		// TODO Auto-generated constructor stub
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List <Car> getCars() {
		return cars;
	}
	public void setCars(List <Car> cars) {
		this.cars = cars;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
