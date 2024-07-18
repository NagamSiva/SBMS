package in.ashokit.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.IUserService;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Override
	public Integer saveUser(User user) {
		
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return  userRepo.save(user).getId();
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		Optional<User> optional = userRepo.findByUsername(username);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=findByUsername(username);
		if(user==null)
		throw new UsernameNotFoundException(
					new StringBuffer()
					.append("User name ")
					.append(username)
					.append(" not found!")
					.toString()
				);
		List<GrantedAuthority> authorities=
		user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.toUpperCase())).collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
