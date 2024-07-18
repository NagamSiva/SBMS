package ashok.it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ashok.it.beans.Car;
import ashok.it.config.AppConfig;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = context.getBean(Car.class);
		car.drive();
	}
}
