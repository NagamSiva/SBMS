package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Student_Dtls;

public interface StudentRepo extends JpaRepository<Student_Dtls, Integer>{
	
	@Query(value = "call getStudentDetails()", nativeQuery = true)
	public List<Student_Dtls> getAllStudents();

}

/*
 * DELIMITER $$ create procedure getStudentDetails() begin select * from
 * student_dtls; end $$ DELIMITER ;
 * 
 * CALL getStudentDetails();
 */