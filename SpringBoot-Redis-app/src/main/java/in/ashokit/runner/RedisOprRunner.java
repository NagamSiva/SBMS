package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ashokit.dao.IStudentDao;
import in.ashokit.model.Student;

@Component
public class RedisOprRunner implements CommandLineRunner{

	@Autowired
	private IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		dao.addStudent(new Student(101,"SAM",500.25));
		dao.addStudent(new Student(102,"SYED",800.25));
		dao.addStudent(new Student(103,"RAM",600.25));
		
		dao.getAllStudent().forEach((k,v)->System.out.println(k+"-----"+v)); 
	}

}
