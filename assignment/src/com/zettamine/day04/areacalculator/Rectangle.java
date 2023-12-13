package com.zettamine.day04.areacalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Rectangle extends Shape{
	private double length;
	private double width;
	@Override
	public double area() {
		
		return length * width;
	}
	@Override
	public double volume() {
		return -1;
	}

}
