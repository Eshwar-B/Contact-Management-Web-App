package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
}
