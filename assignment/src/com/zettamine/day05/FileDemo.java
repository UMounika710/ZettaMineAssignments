package com.zettamine.day05;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		final String PATH = "C:/CJava";
		String dirName = "java";
		File file = new File(PATH + "/"+dirName);
		file.mkdirs();
		System.out.println("Directory created");
		String fName = "java.txt";
		file = new File(file.getAbsolutePath() + "/" + fName);
		file.createNewFile();
		System.out.println("File created");
		
		if(args.length != 2) {
			System.out.println("please provide old file name and new file name");
			
		}
		
		String oldFileName = args[0];
		String newFileName = args[1];
		
		File oldFile = new File(oldFileName);
		File newFile = new File(newFileName);
		if(! oldFile.exists()) {
			System.out.println("This old file does not exist");
		}
		
		oldFile.renameTo(newFile);
		System.out.println(oldFile.getAbsolutePath() + " | " + newFile.getAbsolutePath());
		
		
	}

}
