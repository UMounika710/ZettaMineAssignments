package com.zettamine.day1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BillGeneration {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Enter the no of pizzas bought: ");
		int noOfPizzas = sc.nextInt();
		
		System.out.print("Enter the no of puffs bought: ");
		int noOfPuffs = sc.nextInt();
		
		System.out.print("Enter the no of cool drinks bought: ");
		int noOfDrinks = sc.nextInt();
		
		generateBill(noOfPizzas, noOfPuffs,noOfDrinks);
		sc.close();

	}
	
	public static void generateBill(int noOfPizzas, int noOfPuffs, int noOfDrinks) {
		double amount=0;
		System.out.println("\tBill Details");
		System.out.println("No of Pizzas: \t\t" + noOfPizzas + "\t Cost: " + (noOfPizzas*100));
		amount += (noOfPizzas*100);
		System.out.println("No of Puffs: \t\t" + noOfPuffs + "\t Cost: " + (noOfPuffs*100));
		amount += (noOfPuffs*100);
		System.out.println("No of Cool Drinks: \t" + noOfDrinks + "\t Cost: " + (noOfDrinks*100));
		amount += (noOfDrinks*100);
		System.out.println();
		System.out.printf("Total price = %.2f \n", amount);
		System.out.println("ENJOY THE SHOW!!!");
	}


	
}
