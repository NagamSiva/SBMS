package in.ashokit.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import in.ashokit.dao.IStudentDao;
import in.ashokit.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private final String KEY = "STUDENT";
	
	//ref Type. key Type, valType
	@Resource(name="rt")
	private HashOperations<String, Integer, Student> opr;
	
	@Override
	public void addStudent(Student s) {
		opr.putIfAbsent(KEY, s.getStdId(), s);	
	}

	@Override
	public void modifyStudent(Student s) {
		opr.put(KEY, s.getStdId(), s);
	}

	@Override
	public void getOneStudent(Integer id) {
		opr.get(KEY, id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		return opr.entries(KEY);
	}

	@Override
	public void removeStudent(Integer id) {
		opr.delete(KEY, id);
	}

}
