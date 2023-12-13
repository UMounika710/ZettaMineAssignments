package com.zettamine.day04.areacalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sphere extends Shape implements Spatial{
	private double radius;

	@Override
	public double area() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double volume() {
		return (4 * Math.PI * Math.pow(radius, 3))/3;
	}

}
