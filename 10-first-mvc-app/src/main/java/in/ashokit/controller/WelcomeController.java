package in.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping(value = "/welcome")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mgs", "Welcome to Ashok it....");
		mav.setViewName("index");
		mav.setStatus(HttpStatus.ACCEPTED);
		HttpStatus status = mav.getStatus();
		System.out.println(status);
		return mav;
		
	}

}
