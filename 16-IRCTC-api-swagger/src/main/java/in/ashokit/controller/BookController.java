package in.ashokit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Request.PassengerDetails;
import in.ashokit.Response.TicketData;

@RestController
public class BookController {

	private Map<Integer, TicketData> tickets = new HashMap<>();

	int id=100;
	@PostMapping(value = "/ticket", 
			consumes = { "application/xml", "application/json" }, 
			produces = {"application/xml", "application/json" })
	public TicketData bookTicket(@RequestBody PassengerDetails details) {

		TicketData t = new TicketData();
		t.setTicketId(id);
		t.setFrom(details.getFrom());
		t.setTicketamt("500");
		t.setTo(details.getTo());
		t.setTicketStatus("OK");
		t.setDoj(details.getDoj());
		tickets.put(id, t);
		id++;
		
		return t;
	}

	@GetMapping(value = "/ticket/{ticketId}",
			produces = {"application/xml","application/json"})
	public TicketData getTicket(@PathVariable Integer ticketId) {
		
		TicketData data = tickets.get(ticketId);
		return data;
	}
}
