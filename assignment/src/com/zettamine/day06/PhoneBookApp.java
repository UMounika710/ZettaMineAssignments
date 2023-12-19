package com.zettamine.day06;

import java.util.Scanner;

public class PhoneBookApp {
	

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		PhoneBook phoneBook = new PhoneBook();
		Contact contact;
		while(true) {
		System.out.println("Menu\n"
				+ "1. Add Contact\n"
				+ "2. Display all Contacts\n"
				+ "3. Search Contact by phone \n"
				+ "4. Remove Contact\n"
				+ "5. Exit\n");
		
		System.out.println("Enter your choice: ");
		int opt = sc.nextInt();
		switch (opt) {
		case 1:{ 
			sc.nextLine();
			System.out.println("Add a Contact:");
			System.out.print("Enter the First Name: ");
			String fName = sc.nextLine();
			System.out.print("Enter the Last Name: ");
			String lName = sc.nextLine();
			sc.nextLine();
			System.out.print("Enter the Phone No.:");
			long phone = sc.nextLong();
			System.out.print("Enter the Email: ");
			sc.nextLine();
			String email = sc.nextLine();
			
			contact =new Contact(fName, lName, phone, email);
			phoneBook.addContact(contact);
			System.out.println("Contact added successfully !!!");
			break;
		}
		case 2: {
			System.out.println("First Name\tLast Name\tPhone No\tEmail");
			for(Contact c: phoneBook.viewAllContacts()) {
				System.out.printf("%s\t%s\t%d\t%s", c.getFirstName(),c.getLastName(),c.getPhoneNumber(),c.getEmailId());
			}
			break;
		}
		case 3: {
			System.out.print("Enter the Phone number to search contact: ");
			long phone = sc.nextLong();
			if(phoneBook.viewContactByPhoneNo(phone) != null) {
				System.out.println("First Name: " + phoneBook.viewContactByPhoneNo(phone).getFirstName() + 
						" | " + "Last Name: " +  phoneBook.viewContactByPhoneNo(phone).getLastName() + " | " 
						+ "Phone No.: " + phoneBook.viewContactByPhoneNo(phone).getPhoneNumber() + " | " 
						+ "Email: " + phoneBook.viewContactByPhoneNo(phone).getEmailId());
			}else {
				System.out.println("No contact exist with this phone number");
			}
			break;
		}
		case 4: {
			System.out.print("Enter the Phone number to remove : ");
			long phoneNo = sc.nextLong();
			System.out.print("Do you want to remove the contact (Y/N): ");
			sc.next();
			String option = sc.nextLine();
			if(phoneBook.removeContact(phoneNo)) {
				System.out.println("The contact is successfully deleted.");
			}else {
				System.out.println("Contact is not present");
			}
			
			break;
		}
		case 5: {
			System.out.println("Thank you!!!");
			System.exit(0);
			break;
		}
		default: System.err.println("enter valid option");
		break;
		
		
		//sc.close();
		}
	}
	}

}
