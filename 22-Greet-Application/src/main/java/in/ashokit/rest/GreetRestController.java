package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	
	@Autowired
	private Environment evn;
	
	
	@GetMapping("/greet")
	public String greetMessage() {
		return "Good Nigth..!!! ("+evn.getProperty("server.port")+")";
	}

}
