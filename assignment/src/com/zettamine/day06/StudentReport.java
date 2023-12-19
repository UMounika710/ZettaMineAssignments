package com.zettamine.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentReport {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> studentList = new ArrayList<Student>();
		
		
		
		while(true) {
			System.out.println("Enter Student’s Name, Location, Email and Mobile:  ");
			//String[] input = sc.nextLine().split(" ");
			List<String> input = Arrays.asList(sc.nextLine().split(" "));
			Student student = new Student(input.get(0),input.get(1),input.get(2),Long.parseLong(input.get(3)));
			studentList.add(student);
			System.out.print("Do you want to add more students[Y/N]: ");
			String opt = sc.next();
			if(opt.equalsIgnoreCase("Y")) {
				continue;
			}else if(opt.equalsIgnoreCase("Y")) {
				//getReport(studentList);
				System.out.printf("\tLocation\t\tCount");
				System.out.println(getReport(studentList));
			}else {
				System.err.println("Invalid input");
				System.exit(0);
			}
			
		}
		//sc.close();

	}
	static HashMap<String, Integer> getReport(List<Student>  studentlist) {
		HashMap<String, Integer> map = new HashMap<>();
		for(Student stu : studentlist) {
			if(map.containsKey(stu.getLocation())) {
				int value = map.get(stu.getLocation());
				map.put(stu.getLocation(), value+1);
			}else {
				map.put(stu.getLocation(), 1);
			}
		}
		
		return map;
	}

}
