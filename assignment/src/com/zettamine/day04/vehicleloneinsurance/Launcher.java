package com.zettamine.day04.vehicleloneinsurance;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter vehicleNumber: ");
		String num = sc.next();
		System.out.print("enter modelName: ");
		String name = sc.next();
		sc.nextLine();
		System.out.print("enter vehicleType: ");
		String type = sc.nextLine();
		//sc.nextLine();
		System.out.print("enter price: ");
		double price = sc.nextDouble();
		
		Vehicle vehicle = new Vehicle(num, name, type, price);
		System.out.println(vehicle.getVehicleType());
		System.out.println(vehicle.issueLoan());
		System.out.println(vehicle.takeInsurance());
		sc.close();
	}

}
