package com.zettamine.day06;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneBook {
	private List<Contact> phoneBook = new ArrayList<Contact>();
	
	public void addContact(Contact contactObj) {
		getPhoneBook().add(contactObj);
	}

	public List<Contact> viewAllContacts(){
		return getPhoneBook();
	}
	
	public Contact viewContactByPhoneNo(long phoneNumber) {
		for(Contact contact : getPhoneBook()) {
			if(contact.getPhoneNumber() == phoneNumber) {
				return contact;
			}
		}
		return null;
	}
	
	public boolean removeContact(long phoneNumber) {
		for(Contact contact : getPhoneBook()) {
			if(contact.getPhoneNumber() == phoneNumber) {
				getPhoneBook().remove(contact);
				return true;
			}
		}
		return false;
	}
	
	
}
