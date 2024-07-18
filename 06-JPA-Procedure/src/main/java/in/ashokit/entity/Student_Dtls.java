package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student_Dtls {

	@Id
	private Integer studentId;

	private String studentName;

	private Long studentRank;

	private String studentGender;

	public Student_Dtls() {
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentRank() {
		return studentRank;
	}

	public void setStudentRank(Long studentRank) {
		this.studentRank = studentRank;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public Student_Dtls(Integer studentId, String studentName, Long studentRank, String studentGender) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRank = studentRank;
		this.studentGender = studentGender;
	}
	
	

}
