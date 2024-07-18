package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	 @Autowired
	    private RestaurantService service;

	    @GetMapping
	    public String greetingMessage() {
	        return service.greeting();
	    }

	    @GetMapping("/orders/status/{orderId}")
	    public OrderResponseDTO getOrder(@PathVariable String orderId) {
	        return service.getOrder(orderId);
	    }

}
