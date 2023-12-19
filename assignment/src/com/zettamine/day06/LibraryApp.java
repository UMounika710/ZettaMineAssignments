package com.zettamine.day06;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book book;
		Library library = new Library();
		System.out.println("1. Add Book\n"
				+ "2. Display all Book Details\n"
				+ "3. Search Book by Author \n"
				+ "4. Count Number of books - by book name\r\n"
				+ "5. Exit\n"
				);
		
		
		while(true) {
			System.out.print("Enter your choice: ");
			int opt = sc.nextInt();
		switch (opt) {
		case 1:{ 
			System.out.print("Enter the isbn no: ");
			long isbn = sc.nextLong();
			sc.nextLine();
			System.out.print("Enter the book name: ");
			String title = sc.nextLine();
			System.out.print("Enter the author name: ");
			String author = sc.nextLine();
			book = new Book(isbn,title,author);
			library.addBook(book);
			break;
		}
		case 2:{
			System.out.println("ISBN NO\t\tTITLE\t\tAUTHOR");
			for(Book books : library.viewAllBooks()) {
				System.out.printf("%d\t\t%s\t\t%s\n",books.getIsbnNo(),books.getBookTitle(),books.getBookAuthor());
			}
		break;
		}	

		case 3:{
			sc.nextLine();
			System.out.print("Enter the author name: ");
			String authorName = sc.nextLine();
			List<Book> booksByAuthor = library.viewBooksByAuthor(authorName);
			if(booksByAuthor.size() > 0) {
			for(Book bookOfAuthor : booksByAuthor) {
				System.out.println("ISBN no: " + bookOfAuthor.getIsbnNo() + " | " + 
						"Book name: " + bookOfAuthor.getBookTitle() + " | " + 
						"Author name " + bookOfAuthor.getBookAuthor());
				}
			}else {
				System.out.println("None of the book published by the author Henry");
			}
			break;
		}
		case 4:{
			sc.nextLine();
			System.out.print("Enter the author name: ");
			String bname = sc.nextLine();
			System.out.println("Number of books with name " + bname + " : " + library.countNoOfBook(bname));
			
			break;
		}
		case 5:
			System.out.println("Thank you!!!");
			System.exit(0);
			break;
		default: System.err.println("enter valid option");
		break;
			}
		
		}

	}

}
