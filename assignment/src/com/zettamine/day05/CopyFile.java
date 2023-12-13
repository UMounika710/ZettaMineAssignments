package com.zettamine.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args){
		if(args.length != 2) {
			System.out.println("please provide source file name and destination file names");
			
		}
		
		String sourceFilePath = args[0];
		String destinationFilePath = args[1];
		
		File sourceFile = new File(sourceFilePath);
		File destinationFile = new File(destinationFilePath);
		if(!sourceFile.exists()) {
			System.out.println("This source file does not exist");
		}
		
		try(FileReader fileReader = new FileReader(sourceFile);
				FileWriter fileWriter = new FileWriter(destinationFile)){
					int character;
					while((character = fileReader.read())!= -1){
						fileWriter.write(character);
						
					}
					System.out.println("File copied successfully");
				} catch (IOException e) {
					System.out.println("Unable to copy the file from source file to destination file");
					//e.printStackTrace();
				} 
		
		

	}

}
