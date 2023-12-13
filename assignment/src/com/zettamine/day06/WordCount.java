package com.zettamine.day06;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class WordCount {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in); 
		System.out.println("Enter student's article ");
		String article = sc.nextLine();
		String[] words = article.split("[,;:.?!\\s]+");  //splitting input string based on regex pattern
		System.out.println("Number of words " + words.length);
		
		Map<String, Integer> uniqueWords = new TreeMap<>();  //using TreeMap(word as key and no of times occured as value) to sort in alphabetical order
	
		for(String word : words) {
			if(uniqueWords.containsKey(word.toLowerCase())) {
				int value = uniqueWords.get(word.toLowerCase());
				uniqueWords.put(word.toLowerCase(), value+1);  // if word is already present in map, updating it's value by 1
			}else {
				uniqueWords.put(word.toLowerCase(), 1); // if word not present, adding word as key and 1 as value
			}
		}

		System.out.println("Words with the count ");
		for(Map.Entry<String, Integer> entry : uniqueWords.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue()); //display word and it's count
		}
		sc.close();

	}

}
