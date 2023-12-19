package com.zettamine.day06;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Library {
	private List<Book> bookList = new  ArrayList<Book>();
	
	public void addBook(Book bobj) {
		bookList.add(bobj);
	}
	
	public boolean isEmpty() {
		if(getBookList().size() == 0) {
			return true;
		}
		return false;
	}
	
	public List<Book> viewAllBooks(){
		return getBookList();
		
	}
	
	public List<Book> viewBooksByAuthor(String author ){
		List<Book> booksByAuthor = new ArrayList<Book>();
		for(Book book : getBookList()) {
			if(book.getBookAuthor().equalsIgnoreCase(author)) {
				booksByAuthor.add(book);
			}
		}
		return booksByAuthor;
	}
	
	public int countNoOfBook(String bname) {
		int count = 0;
		for(Book book : getBookList()) {
			if(book.getBookTitle().equalsIgnoreCase(bname)) {
				count++;
			}
		}
		return count;
	}

}
