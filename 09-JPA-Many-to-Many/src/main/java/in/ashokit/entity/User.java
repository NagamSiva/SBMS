package in.ashokit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER_TBLS")
@Setter
@Getter
@ToString
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;
	private String city;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	@JoinTable(name="USER_COURSE_TBL",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id") }, 
			inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id") })
	private Set<Course> courses;

}
