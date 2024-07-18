package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.Request.PassengerDetails;
import in.ashokit.Response.TicketData;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService myTripService;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@PostMapping("/bookTicket")
	public String bookTicket(PassengerDetails passengerDetails, Model model) {
		
		TicketData ticketDataInfo = myTripService.bookTicket(passengerDetails);
		model.addAttribute("ticketdata", ticketDataInfo);
		return "success";
	}

}
