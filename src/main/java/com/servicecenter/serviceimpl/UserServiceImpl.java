package com.servicecenter.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecenter.entities.User;
import com.servicecenter.repository.UserRepo;
import com.servicecenter.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public boolean addUser(User user) {
		if(this.userRepo.save(user)!=null)
			return true;
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		return this.userRepo.findUser(userId);
	}

	@Override
	public boolean deleteUser(String userId) {
		if(this.userRepo.deleteById(userId)!=null)
			return true;
		return false;
	}

}
