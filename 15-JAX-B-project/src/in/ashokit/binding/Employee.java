package in.ashokit.binding;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private Integer id;
	private String name;
	private String role;
	private float salary;

	private Address address;

	public Employee() {
	}

	public Employee(Integer id, String name, String role, float salary, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.address = address;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", address="
				+ address + "]";
	}

}
