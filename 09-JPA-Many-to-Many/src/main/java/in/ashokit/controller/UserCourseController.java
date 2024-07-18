package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.entity.User;
import in.ashokit.repository.CourseRepo;
import in.ashokit.repository.UserRepo;

@Controller
public class UserCourseController {

	private UserRepo userRepo;
	private CourseRepo courseRepo;

	public UserCourseController(UserRepo userRepo, CourseRepo courseRepo) {
		super();
		this.userRepo = userRepo;
		this.courseRepo = courseRepo;
	}
	
	
	@PostMapping("/save")
	public void  saveUserDetails(@RequestBody User user) {
		userRepo.save(user);
		System.out.println("Record INSERTEd Successfully");
	}
	
	@GetMapping("get/{id}")
	public User getUserDetails(@PathVariable Long id) {
		
		return userRepo.findById(id).orElse(null);
	}

}
