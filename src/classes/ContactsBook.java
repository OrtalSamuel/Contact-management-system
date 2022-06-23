package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import Intefaces.ContactManagement;

import exeptions.InvalidInputException;

public class ContactsBook implements ContactManagement {

	private int id;
	private static int COUNTER = 0;
	private String listName;
	private ArrayList<Contact> allContacts;
	private Map<String, Contact> mobilePhoneToContact;
	

	public ContactsBook(String listName) {
		this.allContacts = new ArrayList<Contact>();
		this.listName = listName;
		this.id = ++COUNTER;
		this.mobilePhoneToContact = new HashMap<>();
	}

	@Override
	public void addContact(Contact c1) {
		Contact temp; 
		if((temp = searchContactByMobile(c1.getMobilePhone())) != null ||
			(temp = searchContactByName(c1.getName(), c1.getFamilyName())) != null)
		{
			deleteContact(temp.getName(), temp.getFamilyName());
		}
		allContacts.add(c1);
		Collections.sort(allContacts, new SortContactsByName());
		mobilePhoneToContact.put(c1.MobilePhone, c1);
		
	}

	@Override
	public boolean deleteContact(String firstName, String lastName) {
		Contact c1;
		c1 = searchContactByName(firstName, lastName);
		if (c1 != null) {
			allContacts.remove(c1);
			mobilePhoneToContact.remove(c1.MobilePhone);
		}
		return true;
	}

	@Override
	public Contact searchContactByName(String firstName, String lastName) {
		for (Contact c1 : allContacts) {
			if (c1.getFamilyName().equals(lastName) && c1.getName().equals(firstName)) {
				return c1;
			}
		}
		return null;
	}

	@Override
	public Contact searchContactByMobile(String mobileNumber) {
		if (mobilePhoneToContact.containsKey(mobileNumber)) {
			return mobilePhoneToContact.get(mobileNumber);
		}
		return null;
	}

	@Override
	public void printAllContacts() {
		//ContactIterator c= new ContactIterator(allContacts);
		Iterator<Contact> c = allContacts.iterator();
		System.out.println("LIST NAME: " + listName);
		System.out.println("--------------------------");
		if (c.hasNext()==false) {
			System.out.println("There Is No Contacts!");
		}
		while (c.hasNext()) {
			System.out.println(c.next());
		}
		System.out.println("--------------------------");
	}

	
}
