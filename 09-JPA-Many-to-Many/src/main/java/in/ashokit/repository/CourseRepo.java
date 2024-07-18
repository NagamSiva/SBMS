package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

}
