package com.zettamine.day04.areacalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Cube extends Shape implements Spatial{
	private double length;
	private double width;
	private double height;
	
	@Override
	public double area() {
		return length * width * height;
	}
	@Override
	public double volume() {
		return (2 * length * width) + (2 * length * height) + (2* width * height);
	}

}
