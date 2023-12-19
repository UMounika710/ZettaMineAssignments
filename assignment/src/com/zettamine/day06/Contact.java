package com.zettamine.day06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Contact {
	private String firstName;
	private String lastName;
	private long  phoneNumber;
	private String emailId;


}
