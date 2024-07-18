package ashok.it.beans;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements IEngine {

	public DieselEngine() {
		System.out.println("constructor :: Diesel Engine");
	}
	
	@Override
	public void start() {
		System.out.println("Diesel engine started...");
	}

}
