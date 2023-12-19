package com.zettamine.day06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@AllArgsConstructor
public class Book {
	private	long isbnNo;
	private	String bookTitle;
	private	String bookAuthor;


}
