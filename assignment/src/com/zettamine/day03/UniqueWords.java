package com.zettamine.day03;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in); 
		System.out.println("Enter student's article ");
		String article = sc.nextLine();
		String[] words = article.split("[,;:.?!\\s]+");
		System.out.println("Number of words " + words.length);
		
		Set<String> uniqueWords = new TreeSet<>();
		
		for(String word : words) {
			uniqueWords.add(word.toLowerCase());
		}
		System.out.println("Number of unique words " + uniqueWords.size());
		System.out.println("The words are :" + uniqueWords);
		sc.close();

	}

}
