package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {

		Contact save = contactRepository.save(contact);

		if (save != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepository.findAll();
		
		Stream<Contact> stream = contacts.stream();
		        Stream<Contact> filter = stream.filter(contact -> contact.getActiveSwitch() =='Y');
		        		List<Contact> collect = filter.collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Contact findById = contactRepository.findById(cid).get();
		return findById;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if (save == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteById(Integer cid) {
//		boolean existsById = contactRepository.existsById(cid);
//		if (existsById) {
//			contactRepository.deleteById(cid);
//			return true;
//		} else {
//
//			return false;
//		}
		// }

//		 Optional<Contact> findById = contactRepository.findById(cid);
//		
//		if(findById.isPresent()) {
//			contactRepository.deleteById(cid);
//			return true;
//			}else {
//				return false;
//			}

		Optional<Contact> contact = contactRepository.findById(cid);

		if (contact.isPresent()) {
			Contact contact2 = contact.get();
			contact2.setActiveSwitch('N');
			contactRepository.save(contact2);
			return true;
		} else
			return false;

	}
}
