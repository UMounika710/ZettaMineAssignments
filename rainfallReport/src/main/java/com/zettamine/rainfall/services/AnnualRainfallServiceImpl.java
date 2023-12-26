package com.zettamine.rainfall.services;

import java.util.List;

import com.zettamine.rainfall.dao.RainfallDAO;
import com.zettamine.rainfall.dao.RainfallDAOImpl;
import com.zettamine.rainfall.dto.AnnualRainfall;

public class AnnualRainfallServiceImpl implements AnnualRainfallService {
	RainfallDAO dao;
	
	public AnnualRainfallServiceImpl() {
		super();
		dao = new RainfallDAOImpl();
	}

	@Override
	public void saveAnnualRainfall(List<AnnualRainfall> rainfall) {
		dao.saveAnnualRainfall(rainfall);
	}

	@Override
	public void findMaximumRainfallCities() {
		List<AnnualRainfall> annualRainfall = dao.findMaximumRainfallCities();
		for(AnnualRainfall rainfall : annualRainfall) {
			System.out.printf("| %-5d | %-15s | %.2f |",rainfall.getCityPincode(),rainfall.getCityName(),rainfall.getAverageAnnualRainfall());
			System.out.println();
		}
		
	}

}
