package in.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.repository.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		StudentRepo studentRepo = context.getBean(StudentRepo.class);

		List<Object[]> list = studentRepo.getStudentRankAndGender();
		
		for(Object obj[]:list) {
			System.out.println("Rank :"+obj[1]);
		}

	}
}
