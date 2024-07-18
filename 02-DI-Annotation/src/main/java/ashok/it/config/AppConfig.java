package ashok.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ashok.it.beans.Motor;

@Configuration
@ComponentScan(basePackages = {"ashok.it"})
public class AppConfig {
	
	@Bean
	public Motor startMotor() {
		return new Motor();
	}

}
