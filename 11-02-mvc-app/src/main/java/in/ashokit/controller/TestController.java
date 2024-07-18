package in.ashokit.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepo;

@Controller
public class TestController {

	private UserRepo userRepo;

	public TestController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/")
	public String welcome() {

		/*
		 * ModelAndView mav = new ModelAndView(); mav.addObject("msg",
		 * "Please fill the below form"); mav.setViewName("index");
		 */
		return "index";
	}

	@PostMapping("/user")
	public ModelAndView saveUser(User user) {
		
		ModelAndView mav = new ModelAndView();
		userRepo.save(user);
		mav.addObject("msg", user.getName()+" Record inserdet successfully...");
		
		mav.setViewName("register");
//		model.addAttribute("msg", user.getName()+" data inserted successfully....");
		
		return mav;

	}

}
