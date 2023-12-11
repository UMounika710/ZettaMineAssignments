package com.zettamine.day01;

import java.util.Scanner;

public class DisplayCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[4];
		System.out.println("Enter 4 Numbers:");
		for(int i = 0; i< 4; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i< 4; i++) {
			System.out.println(num[i] + "-" + (char)num[i]);
		}
		sc.close();

	}

}
