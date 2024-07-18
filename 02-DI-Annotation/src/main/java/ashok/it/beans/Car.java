package ashok.it.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	@Qualifier("eng")
	private IEngine eng;
	
	public void drive() {
		eng.start();
	}

}
