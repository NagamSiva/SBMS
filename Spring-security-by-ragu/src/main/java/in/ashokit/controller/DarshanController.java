package in.ashokit.controller;

import java.security.Principal;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.model.Ticket;

@RestController
public class DarshanController {
	
	@GetMapping("/book")
	public Ticket bookTicket(Principal principal) {
		Random r = new Random();
		Ticket t = new Ticket();
		t.setName(principal.getName());
		t.setBookingId("INR"+100000 + r.nextInt(900000));
		
		return t;
	}

}
