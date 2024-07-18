package com.ashok.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ashok.bean.Car;

public class Main {

	public static void main(String[] args) {
		
	ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
	Car car = context.getBean(Car.class);
		
		car.drive();

	}

}

