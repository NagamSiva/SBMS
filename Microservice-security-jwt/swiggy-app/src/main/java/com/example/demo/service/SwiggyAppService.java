package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.RestaurantServiceClient;
import com.example.demo.dto.OrderResponseDTO;

@Service
public class SwiggyAppService {
	
	  @Autowired
	    private RestaurantServiceClient restaurantServiceClient;

	    public String greeting() {
	        return "Welcome to Swiggy App Service";
	    }

	    public OrderResponseDTO checkOrderStatus(String orderId) {
	        return restaurantServiceClient.fetchOrderStatus(orderId);
	    }

}
