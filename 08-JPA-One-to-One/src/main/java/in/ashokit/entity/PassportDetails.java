package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PassportDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String passportNum;
	private LocalDate passportIssuseDate;
	private LocalDate passportExprieDate;
	
	@OneToOne
	@JoinColumn(name ="person_Id")
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public LocalDate getPassportIssuseDate() {
		return passportIssuseDate;
	}

	public void setPassportIssuseDate(LocalDate passportIssuseDate) {
		this.passportIssuseDate = passportIssuseDate;
	}

	public LocalDate getPassportExprieDate() {
		return passportExprieDate;
	}

	public void setPassportExprieDate(LocalDate passportExprieDate) {
		this.passportExprieDate = passportExprieDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
