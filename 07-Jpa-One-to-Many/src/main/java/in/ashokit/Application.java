package in.ashokit;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Address;
import in.ashokit.entity.Employee;
import in.ashokit.repository.AddressRepo;
import in.ashokit.repository.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeRepo empRepo = context.getBean(EmployeeRepo.class);
		AddressRepo addressRepo = context.getBean(AddressRepo.class);

		/*
		 * Employee e = new Employee(); e.setEmpName("Siva"); e.setEmpSalary(25000l);
		 * 
		 * Address a1 = new Address(); a1.setCity("HYD"); a1.setState("TS");
		 * a1.setCountry("India"); a1.setPincode("500084"); a1.setEmp(e);
		 * 
		 * Address a2 = new Address(); a2.setCity("VIZAG"); a2.setState("AP");
		 * a2.setCountry("India"); a2.setPincode("533401"); a2.setEmp(e);
		 * 
		 * List<Address> list = Arrays.asList(a1, a2); e.setEmpAdd(list);
		 * 
		 * empRepo.save(e);
		 */
		
		/*
		 * Employee emp = empRepo.findById(1).get(); Integer empId = emp.getEmpId();
		 * String name = emp.getEmpName(); Long empSalary = emp.getEmpSalary();
		 * List<Address> empAdd = emp.getEmpAdd();
		 * 
		 * System.out.println(empId); System.out.println(name);
		 * System.out.println(empSalary); //System.out.println(empAdd.isEmpty());
		 * for(Address a:empAdd) { System.out.println(a.getAddrId());
		 * System.out.println(a.getCity()); System.out.println(a.getState());
		 * System.out.println(a.getPincode()); System.out.println(a.getCountry());
		 * 
		 * }
		 */
		

		/*
		 * Address add = addressRepo.findById(1).get(); Integer addrId =
		 * add.getAddrId(); String city = add.getCity(); String country =
		 * add.getCountry(); String state = add.getState(); String pincode =
		 * add.getPincode(); Employee emp = add.getEmp();
		 * 
		 * System.out.println(addrId+" : "+city+" : "+country+" : "+state+" : "+pincode)
		 * ;
		 * 
		 * System.out.println(emp.getEmpId()+" : "+emp.getEmpName()+" : "+emp.
		 * getEmpSalary());
		 */
		
		
		//addressRepo.deleteById(1);
		empRepo.deleteById(1);
		System.out.println("Record Inserted....");

	}

}
