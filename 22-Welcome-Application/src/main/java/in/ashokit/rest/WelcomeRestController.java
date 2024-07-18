package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.GreetInterface.GreetFeign;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private Environment evn;
	
	@Autowired
	private GreetFeign greetFeign;
	
	@GetMapping("/welcome")
	public String welcomeMessage() {
		
	
		String welcome= "Welcome to Hyderabad!!! ("+evn.getProperty("server.port") +")";
		String greet=greetFeign.invokeGreet();
		return greet+" "+welcome;
		
	}

}
