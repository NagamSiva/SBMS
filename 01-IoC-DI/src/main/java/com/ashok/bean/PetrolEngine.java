package com.ashok.bean;

public class PetrolEngine implements IEngine {

	public PetrolEngine() {
		System.out.println("petrolEngine :: constructor");
	}

	public int start() {
		System.out.println("petrol engine started....");
		return 1;
	}
}
