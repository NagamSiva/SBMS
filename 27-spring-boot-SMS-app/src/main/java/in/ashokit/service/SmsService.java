package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import in.ashokit.model.SmsPojo;

@Service
public class SmsService {

	private final String ACCOUNT_SID = "ACd8dac9ed9c4ff633078ad84fb537a27a";

	private final String AUTH_TOKEN = "8c2a1d0a56c9aaa213223e63b4f8f22c";

	private final String FROM_NUMBER = "+12705454446";
	
	
	public void send(SmsPojo sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		Message message=Message.creator(new PhoneNumber(sms.getTo()),new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
		
		System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
	}
	
	 public void receive(MultiValueMap<String, String> smscallback) {
	    }

}
