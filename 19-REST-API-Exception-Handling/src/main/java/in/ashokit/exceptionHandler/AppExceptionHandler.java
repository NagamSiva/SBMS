package in.ashokit.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ashokit.binding.ExceptionInfo;
import in.ashokit.exception.CustomerNotFoundException;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handelCnfe(CustomerNotFoundException cnfe){
		
		ExceptionInfo info = new ExceptionInfo();
		info.setCode("EX0011");
		info.setMsg(cnfe.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
		
	}

}
