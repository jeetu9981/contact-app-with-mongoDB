package com.servicecenter.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecenter.entities.Contact;
import com.servicecenter.repository.ContactRepo;
import com.servicecenter.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepo contactRepo;
	@Override
	public boolean addContact(Contact c) {
		if(this.contactRepo.save(c)!=null)
			return true;
		return false;
	}

	@Override
	public List<Contact> allContact(String userId) {
		return this.contactRepo.findbyUserId(userId);
	}

	@Override
	public boolean deleteContact(int contactId) {
		Contact contact=this.contactRepo.findById(contactId).get();
		if(contact!=null) {
			this.contactRepo.delete(contact);
			return true;
		}
		return false;
	}

}
