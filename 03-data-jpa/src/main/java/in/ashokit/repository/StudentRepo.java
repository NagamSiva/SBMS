package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	// select * from student_dtls where student_gender=:gender
	@Query(value = "from Student where gender=:gender")
	public List<Student> getStudentByGender(String gender);

	// 2) select * from student_dtls where student_gender is null
	@Query(value = "from Student where gender is null")
	public List<Student> getStudentByGenderNull();

	// 3) select * from student_dtls where student_rank >= : rank`
	public List<Student> findByRankGreaterThanEqual(Long rank);
	
 	@Query(value = "from Student where rank>=:rank")
	public List<Student> getStudentByRank(Long rank);

	// 4) select * from student_dtls where student_rank <= : rank
	public List<Student> findByRankLessThanEqual(Long rank);

	// 5) select * from student_dtls where student_gender=:gender and student_rank>=:rank

	@Query(value = "from Student where gender=:gender and rank>=:rank")
	public List<Student> getStudentByGender(String gender, long rank);

	// 6) select student_rank, student_gender from student_dtls;
	
	@Query("select rank,gender from Student")
	public List<Object[]> getStudentRankAndGender();

}
