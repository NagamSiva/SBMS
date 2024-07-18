package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	
	// login-page --> security not required
	@GetMapping("/loginpage")
	public String getLogin() {
		return "login page available for all users";
	}
	
	// transfer ---> security required
	@GetMapping("/transfer")
	public String getTransfer() {
		return "Transfer logic";
	}

	// balance ---> security required
	@GetMapping("/balance")
	public String getBalance() {
		return "Balance logic";
	}

	//about-us ---> security not required
	@GetMapping("/about")
	public String getAboutUs() {
		return "about-us is avalible for all";
	}

}
