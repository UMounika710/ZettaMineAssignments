package com.zettamine.rainfall.dao;

import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainfall;

public interface RainfallDAO {
	
	Integer saveAnnualRainfall(List<AnnualRainfall> rainfall);
	
	List<AnnualRainfall> findMaximumRainfallCities ();
	

}
