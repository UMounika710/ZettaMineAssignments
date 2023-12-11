package com.zettamine.day01;

import java.util.GregorianCalendar;

public class TestString {
	
	
	public static void main(String[] args) {
		
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<10000000; i++){
			System.out.println(sb.append(":").append(i));
		}
		long end=new GregorianCalendar().getTimeInMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:"+(end-start));
		System.out.println("Memory used:"+(startMemory-endMemory));
		
		/*
		String str1="Hello!";
		strConcat(str1);
		System.out.println("Final string of strConcat method is -"+ str1);
		
		StringBuffer str2=  new StringBuffer("Hello!");
		strBuffConcat(str2);
		System.out.println("Final string of strBuffConcat method is -"+ str2);
		
		StringBuilder str3 = new StringBuilder("Hello!");
		strBuilderConcat(str3);
		System.out.println("Final string of strBuilderConcat method is -"+str3);
		*/
		
		
	}
	
	
	public static void strConcat(String str1) {
		str1 = str1+"Edurekha";
	}
	
	public static void strBuffConcat(StringBuffer str2) {
		str2.append("Edurekha");
	}
	
	public static void strBuilderConcat(StringBuilder str3) {
		str3.append("Edurekha");
	}
	

}
