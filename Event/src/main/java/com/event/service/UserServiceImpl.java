package com.event.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.event.entity.User;
import com.event.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	   private final UserRepo userRepository;
	   
	   @Autowired
	    public UserServiceImpl(UserRepo userRepository) {
	        this.userRepository = userRepository;
	    }
	   
	@Override
	public User createUser(User user) {
		 return userRepository.save(user);
	}



}
