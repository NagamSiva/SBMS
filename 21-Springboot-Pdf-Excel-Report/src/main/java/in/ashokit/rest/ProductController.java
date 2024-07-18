package in.ashokit.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.ProductService;
import net.sf.jasperreports.engine.JRException;

@RestController
public class ProductController {
	

	
	@Autowired
	private ProductService service;
	
	@GetMapping("report/{format}")
	public String generateProductReport(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
		
	        service.exportJasperReport(format, response);
		return "Pdf Generated...";
	}

}
