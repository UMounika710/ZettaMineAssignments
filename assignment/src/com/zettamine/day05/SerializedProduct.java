package com.zettamine.day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SerializedProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product product;
		List<Product> prodList = new LinkedList<>();
		System.out.print("enter no of products: ");
		int n = sc.nextInt();
		while (n > 0) {
			System.out.print("enter productId: ");
			int prodId = sc.nextInt();
			System.out.println("enter product name: ");
			String prodName = sc.next();
			product = new Product(prodId, prodName);
			prodList.add(product);

			n--;
		}
		sc.close();

		try (FileOutputStream fos = new FileOutputStream("src/stocks.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for(Product serProduct : prodList) {
				oos.writeObject(serProduct);
			}

			

			System.out.println("Product serialization completed");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
