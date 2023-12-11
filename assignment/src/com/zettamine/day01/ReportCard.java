package com.zettamine.day01;

import java.util.Scanner;

public class ReportCard {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("enter student name: ");
		String name = sc.nextLine();
		System.out.print("enter no.of subjects: ");
		int numOfSubjects = sc.nextInt();
		int[] marks = new int[numOfSubjects];
		
		String[] subArray = new String[numOfSubjects];

		//subjectsEntry(subArray);
		marksEntry(marks,subArray);
		System.out.println();
		printReportCard(marks,subArray,name);
		
	}
	
	
	
	private static void subjectsEntry(String[] subArray) {
		for(int i=0; i<subArray.length; i++) {
			System.out.print("enter subject-" + (i+1) + ":");
			subArray[i] = sc.nextLine();
		}
	}



	public static void marksEntry(int[] marks, String[] subArray) {
		
		for(int i=0; i<subArray.length; i++) {
			System.out.print("enter subject-" + (i+1) + ":");
			String sub = sc.next();
			subArray[i] = sub;
		}
		
		for(int i=0; i<marks.length; i++) {
			System.out.print("enter mark for " +subArray[i]+ ":");
			int mark = sc.nextInt();
			marks[i] = mark;
		}
	}
	
	public static void printReportCard(int[] arr,String[] subArray, String name) {
		int total =0;
		System.out.println("-".repeat(40));
		System.out.println("\t\tREPORT CARD");
		System.out.println("NAME:" + name);
		System.out.println("-".repeat(40));
		System.out.println("Subjects\t\tMarks");
		System.out.println("-".repeat(40));
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(subArray[i] + "\t\t" + arr[i]);
			total = total + arr[i];
	
		}
		
		float avg = (float) total/arr.length;
		System.out.println("-".repeat(40));
		System.out.print("Total:"+ total + "\t\tAverage:");
		System.out.printf("%.2f", avg);
		System.out.println();
		System.out.println("-".repeat(40));
	}

}
