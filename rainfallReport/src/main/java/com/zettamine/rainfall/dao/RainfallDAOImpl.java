package com.zettamine.rainfall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainfall;

public class RainfallDAOImpl implements RainfallDAO {
	private static Statement st = null;
	
	public RainfallDAOImpl() {
		super();
		try {
			Connection con = DBHandlerDAO.establishConnection();
			st = con.createStatement();
		} catch (Exception e) {
			System.err.println("Connection to Database failed");
		}
	}
	

	@Override
	public Integer saveAnnualRainfall(List<AnnualRainfall> annualRainfall) {
		Integer rows = null;
		for(AnnualRainfall rainfall : annualRainfall) {
			
			String sql = "insert into annualrainfall values("+rainfall.getCityPincode() + ",'" + rainfall.getCityName() + "',"
					+ rainfall.getAverageAnnualRainfall() + ")";
		try {
			 rows = st.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		return rows;
	}

	@Override
	public List<AnnualRainfall> findMaximumRainfallCities() {
		List<AnnualRainfall> averageRainfall = new ArrayList<AnnualRainfall>();
		String sql = "select city_pincode,city_name, max(average_annual_rainfall) as average_rain_fall \r\n"
				+ "from annualrainfall \r\n"
				+ "group by city_pincode,city_name\r\n"
				+ "having MAX(average_annual_rainfall) = (SELECT MAX(average_annual_rainfall) FROM annualrainfall)\r\n"
				+ "ORDER BY city_name";
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				averageRainfall.add(new AnnualRainfall(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return averageRainfall;
	}

}
