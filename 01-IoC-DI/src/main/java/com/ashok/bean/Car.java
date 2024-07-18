package com.ashok.bean;

public class Car {

	private IEngine eng1;

	public Car(IEngine eng) {
		this.eng1 = eng;
	}

//	public void setEng(IEngine eng) {
//		this.eng = eng;
//	}

	public void drive() {

		if (eng1.start() >= 1) {
			System.out.println("Engine started now ready to drive the car..");
		} else {
			System.out.println("Engine not started");
		}
	}

}
