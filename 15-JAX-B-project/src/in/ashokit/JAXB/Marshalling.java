package in.ashokit.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import in.ashokit.binding.Address;
import in.ashokit.binding.Employee;

public class Marshalling {
	
	public static void main(String[] args){
		
		Address add = new Address();
		add.setCity("Tuni");
		add.setCountry("India");
		add.setPincode(533401);
		
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setName("Siva");
		emp.setRole("Developer");
		emp.setSalary(25000);
		emp.setAddress(add);
		
		
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(emp, new File("Employee.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println("Done....!!!");
	}
	

}
