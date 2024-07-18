package in.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nagam
 *
 */


@Entity
@Table(name = "STUDENT_DTLS") // optional
public class Student {

	@Id
	@Column(name="student_id") // optional
	private Integer id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_rank")
	private Long rank;
	
	@Column(name="student_gender")
	private String gender;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public Student(Integer id, String name, Long rank, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rank=" + rank + ", gender=" + gender + "]";
	}
	
	

 
}