package ashok.it.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "eng")
//@Primary

public class PetrolEngine implements IEngine {

	public PetrolEngine() {
		System.out.println("constorcor :: petrol engine");
	}

	@Override
	public void start() {
		System.out.println("petrol engine started...");
	}

}
