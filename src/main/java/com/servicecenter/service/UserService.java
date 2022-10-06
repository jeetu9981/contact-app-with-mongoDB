package com.servicecenter.service;

import java.util.List;

import com.servicecenter.entities.MongoContacts;
import com.servicecenter.entities.User;

public interface UserService {
	public boolean addUser(User user);
	public List<User> getAllUsers();
	public User getUser(String userId);
	public boolean deleteUser(String userId);
	
	public boolean addContact(MongoContacts conatct,String userId);
	public boolean deleteContact(String userId,String number);
}
