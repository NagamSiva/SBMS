package in.ashokit;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.PassportDetails;
import in.ashokit.entity.Person;
import in.ashokit.repository.PassportRepo;
import in.ashokit.repository.PersonRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonRepo personRepo = context.getBean(PersonRepo.class);
		PassportRepo passportRepo = context.getBean(PassportRepo.class);
		

		
		Person p = new Person();
		p.setPersonName("Siva");
		p.setPersonCity("HYd");
		p.setPersonCountry("India");
		
		PassportDetails pd = new PassportDetails();
		pd.setPassportNum("SDBJSCKJJC");
		pd.setPassportIssuseDate(LocalDate.now());
		pd.setPassportExprieDate(LocalDate.now().plusYears(10));
		pd.setPerson(p);
		
		p.setPassportDetails(pd);
		
		
		
		
		
		passportRepo.save(pd);
		
		System.out.println("Record Inserted...");
	}
	

}
