package Intefaces;


import classes.Contact;

public interface ContactManagement {
	

public void addContact(Contact c1);

public boolean deleteContact(String firstName,String lastName);

public Contact searchContactByName(String firstName,String lastName);

public Contact searchContactByMobile(String mobileNumber);

public void printAllContacts();


}
