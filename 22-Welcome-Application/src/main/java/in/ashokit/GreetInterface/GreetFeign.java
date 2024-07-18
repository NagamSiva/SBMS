package in.ashokit.GreetInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(url = "http://localhost:8081/", name="siva")
@FeignClient(name = "GREET-API")
public interface GreetFeign {

	@GetMapping("/greet")
	public String invokeGreet();
}
