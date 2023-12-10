package com.zettamine.day1;

import java.util.Scanner;

public class ResidentValidator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inmate's name: ");
		String residentName = sc.nextLine().trim();
		
		System.out.print("Inmate's father's name: ");
		String fatherName = sc.nextLine().trim();
		
		String regex = "^[A-Za-z]+[A-Za-z ]+$";
		residentNameValidator(residentName,fatherName,regex);
		sc.close();
	}
	public static void residentNameValidator(String resident, String father, String regex) {
		if(resident.matches(regex) && father.matches(regex)) {
			System.out.println(resident.concat(" ").concat(father).toUpperCase());
		}else {
			System.err.println("Invalid name");
		}
	}

}
