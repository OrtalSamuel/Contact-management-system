package classes;

import java.util.Scanner;

import exeptions.InvalidInputException;

public class Menu {
	public void run() throws InvalidInputException {
		String lastName;
		String firstName;
		String mobileNumber;
		String homeNumber;
		int option = 0;

		Scanner input = new Scanner(System.in);
		ContactsBook contactsBook = new ContactsBook("List 1");

		while (option != 6) {
			System.out.println("Contact Editor:");
			System.out.println("1. Add Contact");
			System.out.println("2. Delete Contact");
			System.out.println("3. Search Contact By Full Name");
			System.out.println("4. Search Contact By Mobile");
			System.out.println("5. Print All Contacts");
			System.out.println("6. Exit");

			System.out.println("Choose your option");
			option = input.nextInt();

			System.out.println("Your Option:" + option);

			switch (option) {
			
			case 1:
				
				System.out.println("Add Contact:");

				System.out.print("Enter Last Name: ");
				lastName = input.next();

				System.out.print("Enter first Name: ");
				firstName = input.next();

				System.out.print("Enter home Number: ");
				homeNumber = input.next();

				System.out.print("Enter mobile Number: ");
				mobileNumber = input.next();
				
				try
				{
					checkLastName(lastName);
					checkFirstName(firstName);
					checkHomeNumber(homeNumber);
					checkMobileNumber(mobileNumber);
					Contact c1 =new Contact(firstName, lastName, mobileNumber, homeNumber);
					contactsBook.addContact(c1);
					System.out.println("\n Contact Added or Updated!");
				}
				catch(InvalidInputException e) {
					System.out.println(e.getMessage());
				}				
				System.out.println();
				
				break;

			case 2:
				System.out.println("Delete Contact:");
				
				System.out.print("Enter Last Name: ");
				lastName = input.next();

				System.out.print("Enter first Name: ");
				firstName = input.next();
				
				if(contactsBook.deleteContact(firstName, lastName)==true) {
					System.out.println("\n Contact Deleted!");
				}			
				else {
					System.out.println("\n Contact Not Found!");
				}
				System.out.println();
				
				break;

			case 3:
				System.out.println("Search Contact By Full Name:");
				
				System.out.print("Enter Last Name: ");
				lastName = input.next();

				System.out.print("Enter first Name: ");
				firstName = input.next();
				
				Contact contact = contactsBook.searchContactByName(firstName, lastName);
				if(contact==null) {
					System.out.println("\n Contact Not Found!\n");
				}			
				else {
					System.out.println(contact);
				}
				System.out.println();
					
				break;
				
				
			case 4:
				System.out.println("Search Contact By Mobile:");
				
				System.out.print("Enter Mobile Number: ");
				mobileNumber = input.next();
	
				contact =contactsBook.searchContactByMobile(mobileNumber);
				if(contact==null) {
					System.out.println("\n Mobile Not Found!");
				}
				else {
					System.out.println(contact);
				}
				System.out.println();
				
				break;

			case 5:
				System.out.println("Print All Contacts:");
				contactsBook.printAllContacts();
				
				System.out.println();
				
				break;

			case 6:
				System.out.println("\n You Chose to exit, have a nice day");
				
				System.out.println();
				break;

				
			default:
				System.out.println("\n invalid input,try again");
				System.out.println();
				break;
			}
		}
	}

	private boolean checkFirstName(String name) throws InvalidInputException{
		if (name.length() > 1) {
			return true;
		}
		throw new InvalidInputException("ERROR! Wrong First Name Entered!");
	}
	
	private boolean checkLastName(String name) throws InvalidInputException{
		if (name.length() > 1) {
			return true;
		}
		throw new InvalidInputException("ERROR! Wrong Last Name Entered!");
	}
	
	private boolean checkHomeNumber(String homeNumber) throws InvalidInputException {
		if (homeNumber.length() == 0 || checkValidNumber(homeNumber, 10)) {
			return true;
		}
		else {
			throw new InvalidInputException("ERROR! Wrong Home Number Entered!");
		}
	}

	private boolean checkMobileNumber(String mobileNumber) throws InvalidInputException {
		if (checkValidNumber(mobileNumber, 11) == true) {
			return true;
		}

		else {
			throw new InvalidInputException("ERROR! Wrong Mobile Number Entered!");
		}
	}

	private boolean checkValidNumber(String number, int validLength) {
		int hyphenIndex = validLength - 8;
		if (number.charAt(hyphenIndex) != '-' && number.length() != validLength) { 
			return false;
		}
		for (int i = 0; i < number.length(); i++)
		{ 
			if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9') && i != hyphenIndex)
			{
				return false; 
			} 
		}
		return true;
	}
}
