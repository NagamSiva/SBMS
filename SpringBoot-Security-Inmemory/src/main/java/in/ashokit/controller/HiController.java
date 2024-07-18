package in.ashokit.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	
	@GetMapping("/hi")
	public String hi(Principal principal) {
		return principal.getName();
		
	}

}
