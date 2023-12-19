package com.zettamine.day06;

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
		
		//check if can use StringTokenizer here
		
		Set<String> uniqueWords = new TreeSet<>();
		
		for(String word : words) {
			uniqueWords.add(word.toLowerCase());
		}
		System.out.println("Number of unique words " + uniqueWords.size());
		System.out.println("The words are :");
		for(String word : uniqueWords) {
			System.out.println(word);
		}
		sc.close();

	}

}
