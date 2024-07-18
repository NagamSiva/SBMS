package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "welcome to Ashok It....!!";
	}
	
	@GetMapping("/welcome/{name}")
	@ResponseBody
	public String welcome(@PathVariable("name") String name) {
		return "Welcome ro Ashokit "+name+"...!!!";
	}

}
