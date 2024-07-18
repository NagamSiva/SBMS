package in.ashokit.controller;

import java.lang.System.Logger;

import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

	@GetMapping("/message")
	@ResponseBody
	public String message() {
		return "Good evening everyone..";
	}

}
