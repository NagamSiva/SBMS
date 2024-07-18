package com.ashok.bean;

public class DieselEngine implements IEngine {

	
		public DieselEngine() {
			System.out.println("DieselEngine :: constructor");
		}

		public int start() {
			System.out.println("Diesel engine started....");
			return 1;
	}

}
