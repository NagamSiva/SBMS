package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Employees;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer>{

}
