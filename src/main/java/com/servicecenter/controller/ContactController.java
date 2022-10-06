package com.servicecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecenter.entities.Contact;
import com.servicecenter.exception.Response;
import com.servicecenter.serviceimpl.ContactServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	
	@PostMapping("addcontact")
	public ResponseEntity<Response> addContact(@ModelAttribute Contact contact){
		if(this.contactServiceImpl.addContact(contact))
			return Response.generateResponse("Contact Added...",HttpStatus.CREATED,null);
		else
			return Response.generateResponse("Contact Not Added...",HttpStatus.INTERNAL_SERVER_ERROR,contact);
	}
	
	@GetMapping("getcontacts/{id}")
	public ResponseEntity<Response> getContacts(@PathVariable("id") String userId){
		List<Contact> contacts=this.contactServiceImpl.allContact(userId);
		if(contacts.size()>0)
			return Response.generateResponse("Contact Found...",HttpStatus.FOUND,contacts);
		else
			return Response.generateResponse("ContactNOt Found...",HttpStatus.NOT_FOUND,null);
	}
	
	@DeleteMapping("/deletecontact/{id}")
	public ResponseEntity<Response> deleteContact(@PathVariable("id") int contactId){
		if(this.contactServiceImpl.deleteContact(contactId))
			return Response.generateResponse("Contact Deleted...",HttpStatus.OK,null);
		else
			return Response.generateResponse("Contact Not Deleted...",HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
}
