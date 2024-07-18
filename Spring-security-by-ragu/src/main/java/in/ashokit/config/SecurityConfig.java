package in.ashokit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.ashokit.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	}
	
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/save","/user/login").permitAll()
		.antMatchers("/welcome").hasRole("EMP")
        .antMatchers("/book").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
