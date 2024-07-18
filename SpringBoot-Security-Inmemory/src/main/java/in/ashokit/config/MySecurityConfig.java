package in.ashokit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserDetails kola=User.withUsername("kola").password("kola123").roles("admin","user").build();
		UserDetails siva=User.withUsername("siva").password("siva123").roles("admin").build();
		UserDetails varun=User.withUsername("varun").password("varun123").roles("user").build();
		
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(kola);
		manager.createUser(siva);
		manager.createUser(varun);
		
		auth.userDetailsService(manager);
		
		//auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/hi").hasAnyRole("admin")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}
	

}
