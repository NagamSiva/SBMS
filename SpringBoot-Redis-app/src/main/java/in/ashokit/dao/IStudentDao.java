package in.ashokit.dao;

import java.util.Map;

import in.ashokit.model.Student;

public interface IStudentDao {
	
	void addStudent(Student s);
	void modifyStudent(Student s);
	void getOneStudent(Integer id);
	Map<Integer, Student> getAllStudent();
	void removeStudent(Integer id);

}
