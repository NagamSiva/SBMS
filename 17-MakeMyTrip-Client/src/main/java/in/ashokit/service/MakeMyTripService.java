package in.ashokit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import in.ashokit.Request.PassengerDetails;
import in.ashokit.Response.TicketData;

@Service
public class MakeMyTripService {
	
	@Value("${IRCTC_BookTicket_URl}")
	private String url;
	
	/*
	 * public TicketData bookTicket(PassengerDetails passengerDetails) {
	 * RestTemplate restTemplate = new RestTemplate();
	 *  TicketData ticketData =restTemplate.postForObject(url, passengerDetails , TicketData.class);
	 * System.out.println(ticketData);
	 *  return ticketData; }
	 */
	
	public TicketData bookTicket(PassengerDetails passengerDetails) {
		
		WebClient client = WebClient.create();
		TicketData ticketData= client.post()
									.uri(url)
									.body(BodyInserters.fromValue(passengerDetails))
									.header("Content-Type","application/xml")
									.accept(MediaType.APPLICATION_XML)
									.retrieve()
									.bodyToMono(TicketData.class)
									.block();
		return ticketData;
	}

}
