package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ashokit.model.Student;

@Configuration
public class AppConfig {
	
	//1 Redis Connection
	@Bean
	public RedisConnectionFactory cf() {
		//return new JedisConnectionFactory();
		return new LettuceConnectionFactory();
	}
	
	//2.Redis Template
	@Bean
	public RedisTemplate<String, Student> rt(){
		RedisTemplate<String, Student> template= new RedisTemplate<>();
		template.setConnectionFactory(cf());
		return template;
	}

}
