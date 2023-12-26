package com.zettamine.rainfall.services;

import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainfall;

public interface AnnualRainfallService {
	
	void saveAnnualRainfall(List<AnnualRainfall> rainfall);
	
	void findMaximumRainfallCities ();

}
