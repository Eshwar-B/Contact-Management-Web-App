package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.entity.User;
import in.ashokit.repo.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	public Contact addContact(Contact contact)
	{
		return contactRepo.save(contact);
	}
	
	public List<Contact> getContactForUser(User user)
	{
		return contactRepo.findByUser(user);
	}
	
}
