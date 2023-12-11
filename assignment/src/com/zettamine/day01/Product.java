package com.zettamine.day01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
	private String name;
	private double price;
	private double discountPercentage;
	
	public double calculateDiscount() {
		return price * discountPercentage;
	}

}
