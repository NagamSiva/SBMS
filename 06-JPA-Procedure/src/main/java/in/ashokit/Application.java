package in.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Student_Dtls;
import in.ashokit.repository.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepo bean = context.getBean(StudentRepo.class);
		
		List<Student_Dtls> allStudents = bean.getAllStudents();
		
		for(Student_Dtls s :allStudents) {
			System.out.println(s.getStudentName()+" : "+s.getStudentId()+" : "+s.getStudentRank()+" : "+s.getStudentRank());
		}
	}

}
