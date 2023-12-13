package com.zettamine.day04.areacalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Triangle extends Shape{
	private double base;
	private double height;
	@Override
	public double area() {
		return 0.5 * base * height;
	}
	@Override
	public double volume() {
		return -1;
	}

}
