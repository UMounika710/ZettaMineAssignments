package com.zettamine.day05;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializedProduct {

	public static void main(String[] args) {
		
		int prodId = Integer.parseInt(args[0]);
		
		
		//Product p;
		try(FileInputStream fis = new FileInputStream("stocks.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Product p;
			
			while((p = (Product) ois.readObject()) != null) {
				if(p instanceof Product) {
					Product desProduct = (Product) p;
					if(desProduct.getProductId() == prodId) {
						System.out.println(p);
					}
				}
		}
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}

}
