package com.zettamine.day1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MinDiscountProduct {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("enter the number of items: ");
		List<Product> productList = new LinkedList<>();
		
		int noOfItems = sc.nextInt();
		
		for(int i = 0; i <= noOfItems; i++) {
			String items = sc.nextLine();
			String[] prodDetails = items.split(",");
			if(prodDetails.length == 3) {
				String name = prodDetails[0].trim();
				double price = Double.parseDouble(prodDetails[1].trim());
				double discountPercentage = Double.parseDouble(prodDetails[2].trim());
				
				Product prod = new Product(name, price, discountPercentage);
				productList.add(prod);
			}
		}
		
		System.out.print("Items with Minimum Discount: ");
		for(Product item : findMinDiscountItem(productList)) {
			System.out.print(item.getName() + " ");
		}
		
		
		
		
		sc.close();

	}
	public static List<Product> findMinDiscountItem(List<Product> productList) {
		List<Product> minDiscountProducts = new LinkedList<>();
		double minDiscount =  productList.get(0).calculateDiscount();
		for(Product product : productList) {
			double discount = product.calculateDiscount();
			if(discount < minDiscount) {
				minDiscountProducts.clear();
				minDiscountProducts.add(product);
				minDiscount = discount;
			} else if(discount == minDiscount){
				minDiscountProducts.add(product);
				
			}
		}
		return minDiscountProducts;
	}

}
