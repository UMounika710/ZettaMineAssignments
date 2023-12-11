package com.zettamine.day01;

import java.util.Scanner;

public class AverageAge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ageArray = null;
		System.out.print("Enter total no. of employees: ");
		int noOfEmployees = sc.nextInt();
		if(noOfEmployees >= 2){
			ageArray = new int[noOfEmployees];
			System.out.println("Enter the age for " + noOfEmployees + " employees:");
			for(int i=0; i < noOfEmployees; i++) {
				int age = sc.nextInt();
				ageArray[i] = age;
			
			} 
			
			for(int i=0; i < noOfEmployees; i++) {
				if((ageArray[i] < 28) || (ageArray[i] > 40)) {
					System.err.println("Invalid age encountered!");
					System.exit(0);
				}
			}
		}else {
			System.err.println("Please enter a valid employee count");
			System.exit(0);
		}
		
		System.out.printf("The average age is %.2f",calculateAverage(ageArray));
		sc.close();

	}
	
	public static double calculateAverage(int[] age) {
		int total = 0;
		for(int ele : age) {
			total+=ele;
		}
		double average = (double)total/age.length;
		
		return average;
	}

}
