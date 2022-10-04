package com.servicecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicecenter.entities.User;
import com.servicecenter.exception.Response;
import com.servicecenter.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/signup")
	public ResponseEntity<Response> addUser(@ModelAttribute User user){
		if(this.userServiceImpl.addUser(user))
			return Response.generateResponse("User Register...",HttpStatus.CREATED,null);
		else
			return Response.generateResponse("User Not Register...",HttpStatus.INTERNAL_SERVER_ERROR,user);
	}
	
	
	@GetMapping("/allusers")
	public ResponseEntity<Response> getAllUsers(){
		List<User> users=this.userServiceImpl.getAllUsers();
		if(!users.isEmpty())
			return Response.generateResponse("Found...",HttpStatus.FOUND,users);
		else
			return Response.generateResponse("Not Found...",HttpStatus.NOT_FOUND,null);
	}
	
	@GetMapping("/getsingleuser")
	public ResponseEntity<Response> getUser(@RequestParam("userId") String userId){
		User user=this.userServiceImpl.getUser(userId);
		if(user!=null)
			return Response.generateResponse("Found...",HttpStatus.FOUND,user);
		else
			return Response.generateResponse("Not Found...",HttpStatus.NOT_FOUND,null);
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<Response> deleteUser(@RequestParam("userId") String userId){
		if(this.userServiceImpl.deleteUser(userId))
			return Response.generateResponse("Delete User...",HttpStatus.OK,null);
		else
			return Response.generateResponse("Not Delete...",HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	 
}
