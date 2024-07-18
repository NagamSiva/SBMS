package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.PassportDetails;

public interface PassportRepo extends JpaRepository<PassportDetails, Integer>{

}
