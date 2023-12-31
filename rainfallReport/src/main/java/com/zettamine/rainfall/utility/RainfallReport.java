package com.zettamine.rainfall.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.zettamine.rainfall.dao.DBHandlerDAO;
import com.zettamine.rainfall.dto.AnnualRainfall;
import com.zettamine.rainfall.exceptions.InvalidCityPincodeException;

public class RainfallReport {
	//private static Statement st = null;
	
	public RainfallReport() {
		super();
	
	}
	
	public List<AnnualRainfall>generateRainfallReport(String filePath) throws InvalidCityPincodeException{
		AnnualRainfall rainfall;
		List<AnnualRainfall> averageRainfall = new ArrayList<AnnualRainfall>();
		try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null) {
				List<String> values = Arrays.asList(line.split(","));
				if(validate(values.get(0))) {
					rainfall = new AnnualRainfall();
					rainfall.setCityPincode(Integer.parseInt(values.get(0)));
					rainfall.setCityName(values.get(1));
					double[] monthlyRainfall = values.stream().skip(2).mapToDouble(Double::parseDouble).toArray();
					rainfall.calculateAverageAnnualRainfall(monthlyRainfall);
					averageRainfall.add(rainfall);
				}else {
					String msg = "Invalid Pincode";
					throw new InvalidCityPincodeException(msg);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return averageRainfall;
		
	}
	
	public boolean validate(String cityPincode) {
		String regex = "^\\d{5}$";
		return cityPincode.matches(regex);
	}
	
	/*public List<AnnualRainfall> findMaximumRainfallCities () throws SQLException{
	List<AnnualRainfall> averageRainfall = new ArrayList<AnnualRainfall>();
	String sql = "select city_pincode,city_name, max(average_annual_rainfall) as average_rain_fall \r\n"
			+ "from annualrainfall \r\n"
			+ "group by city_pincode,city_name\r\n"
			+ "having MAX(average_annual_rainfall) = (SELECT MAX(average_annual_rainfall) FROM annualrainfall)\r\n"
			+ "ORDER BY city_name";
	ResultSet rs = st.executeQuery(sql);
	averageRainfall.add((AnnualRainfall) rs);
	return averageRainfall;
}
*/
	

}
