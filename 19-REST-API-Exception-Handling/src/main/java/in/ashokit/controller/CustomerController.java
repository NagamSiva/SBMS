package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exception.CustomerNotFoundException;

@RestController
public class CustomerController {
	
	@GetMapping("/{id}")
	public String getCustomerName(@PathVariable Integer id) {
		
		if(id >= 100) {
			return "Jhon";
		}else {
			throw new CustomerNotFoundException("customer not found!!!");
		}
		
	}

}
