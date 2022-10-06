package com.servicecenter.service;

import java.util.List;

import com.servicecenter.entities.Contact;

public interface ContactService {
	public boolean addContact(Contact c);
	public List<Contact> allContact(String userId);
	public boolean deleteContact(int contactId);
}
