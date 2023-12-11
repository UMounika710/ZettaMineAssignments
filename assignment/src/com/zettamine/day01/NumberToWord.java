package com.zettamine.day01;
import java.util.Scanner;

public class NumberToWord {
	
	public static String digitToWord(int num) {
		int rem=0;
		String word = "";
		while(num > 0) {
			rem = num%10;
			num =num/10; 
		
		switch(rem) {
		case 0: {
			word = "ZERO " + word;
			break;
		}
		case 1: {
			word = "ONE " + word;
			break;
		}
		case 2: {
			word = "TWO " + word;
			break;
		}
		case 3: {
			word = "THREE " + word;
			break;
		}
		case 4: {
			word = "FOUR " + word;
			break;
		}
		case 5: {
			word = "FIVE " + word;
			break;
		}
		case 6: {
			word = "SIX " + word;
			break;
		}
		case 7: {
			word = "SEVEN " + word;
			break;
		}
		case 8: {
			word = "EIGHT " + word;
			break;
		}
		case 9: {
			word = "NINE " + word;
			break;
		}
		}
			
		
		}  
		return word;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		
		sc.close();
		System.out.print(num + " in words ----> " + digitToWord(num));

	}

}
