package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Student;
import in.ashokit.repository.StudentRepo;

@RestController
@RefreshScope
public class WelcomeController {

	@Value("${msg}")
	private String msg;
	
	@Autowired
	private StudentRepo repo;

	@GetMapping("/")
	public String getWelcomeMsg() {
		return msg;
	}
	
	@GetMapping("/get")
	public List<Student> getStudent() {
		
		return repo.findAll();
	}

}
