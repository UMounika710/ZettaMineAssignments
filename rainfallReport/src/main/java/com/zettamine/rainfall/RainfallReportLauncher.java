package com.zettamine.rainfall;

import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainfall;
import com.zettamine.rainfall.exceptions.InvalidCityPincodeException;
import com.zettamine.rainfall.services.AnnualRainfallService;
import com.zettamine.rainfall.services.AnnualRainfallServiceImpl;
import com.zettamine.rainfall.utility.RainfallReport;

public class RainfallReportLauncher {

	public static void main(String[] args) throws InvalidCityPincodeException {
		String filePath = "C:\\Users\\Mounika\\Desktop\\AllCityMonthlyRainfall.txt";
		
		RainfallReport report = new RainfallReport();
		
		 List<AnnualRainfall> annualRainfall = report.generateRainfallReport(filePath);
		 AnnualRainfallService service = new AnnualRainfallServiceImpl();
		 service.saveAnnualRainfall(annualRainfall);
		 service.findMaximumRainfallCities();
		 
		

	}

}
