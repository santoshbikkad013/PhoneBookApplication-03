package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Contact;

public interface ContactServiceI {

	boolean saveContact(Contact contact);

	List<Contact> getAllContact();
	
	Optional<Contact> getContactById(Integer cid);
	
	public boolean updateContact(Contact contact);
	
	   boolean deleteById(Integer cid);
}
