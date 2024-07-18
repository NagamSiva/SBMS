package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.utils.JwtUtil;
import com.google.common.net.HttpHeaders;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JwtUtil jwtUtil;

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			
			ServerHttpRequest request = null;
			if (validator.isSecured.test(exchange.getRequest())) {

				// header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try {
					// REST call to auth service
					// restTemplate.getForObject("http://SECURITY-SERVICE/auth/validate?token=" +
					// authHeader,String.class);
					jwtUtil.validateToken(authHeader);

					// send user details to other microservices
					 request = exchange.getRequest().mutate()
							.header("loggedInUser", jwtUtil.getUsername(authHeader)).build();

				} catch (Exception e) {
					System.out.println("invalid access....!");
					throw new RuntimeException("un authorized access to application");
				}
			}
			return chain.filter(exchange.mutate().request(request).build());
		});
	}

	public static class Config {

	}
}
