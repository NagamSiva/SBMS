package in.ashokit.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COURSE_TBLs")
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private double fee;
	private int modules;
	
	@ManyToMany
	private Set<User> users;

}
