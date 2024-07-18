package in.ashokit.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import in.ashokit.binding.Employee;

public class UnMarshalling {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Employee emp = (Employee) unmarshaller.unmarshal(new File("Employee.xml"));
			
			System.out.println(emp);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
