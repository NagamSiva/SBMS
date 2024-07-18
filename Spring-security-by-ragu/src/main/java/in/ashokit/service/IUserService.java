package in.ashokit.service;

import in.ashokit.entity.User;

public interface IUserService {
	
	public Integer saveUser(User user);
	public User findByUsername(String username);

}
