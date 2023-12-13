package com.zettamine.day04.areacalculator;

import java.util.Scanner;

public class AreaVolumeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape[] shapes = new Shape[5];
		System.out.println("1.Rectangle");
		System.out.println("2.Triangle");
		System.out.println("3.Cube");
		System.out.println("4.Sphere");
		for(int i = 0; i < 5; i++) {
			System.out.print("Enter the shape: ");
			String shape = sc.next();
			switch(shape) {
			case "Rectangle": {
				System.out.print("enter length: ");
				Double length = sc.nextDouble();
				System.out.print("enter width: ");
				Double width = sc.nextDouble();
				shapes[i] = new Rectangle(length, width);
				break;
			}
			case "Triangle": {
				System.out.print("enter base: ");
				Double base = sc.nextDouble();
				System.out.print("enter height: ");
				Double height = sc.nextDouble();
				shapes[i] = new Triangle(base, height);
				break;
			}
			case "Cube": {
				System.out.print("enter length: ");
				Double length = sc.nextDouble();
				System.out.print("enter width: ");
				Double width = sc.nextDouble();
				System.out.print("enter height: ");
				Double height = sc.nextDouble();
				shapes[i] = new Cube(length, width, height);
				break;
			}
			case "Sphere": {
				System.out.print("enter radius: ");
				Double radius = sc.nextDouble();
				shapes[i] = new Sphere(radius);
				break;
			}
			default: {
				System.err.println("Enter valid shape");
				break;
			}
			
			}
			 
		}
		for(Shape shape : shapes) {
			System.out.println("Area: " + shape.area());
			if(shape instanceof Spatial) {
				System.out.println("Volume: " + shape.volume());
			}
		}
		
		
		sc.close();

	}

}
