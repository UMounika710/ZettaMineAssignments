package com.zettamine.rainfall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnualRainfall {
	
	private int cityPincode;
	private String cityName;
	private double averageAnnualRainfall;
	
	public void calculateAverageAnnualRainfall (double monthlyRainfall []) {
		double sum = 0;
		for(double rainfall : monthlyRainfall) {
			sum += rainfall;
		}
		setAverageAnnualRainfall(sum/12);
	}


}
