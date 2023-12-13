package com.zettamine.day04.vehicleloneinsurance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Vehicle implements Loan, Insurance{
	private String vehicleNumber;
	private String modelName;
	private String vehicleType;
	private double price;
	
	public Vehicle(String vehicleNumber, String modelName, String vehicleType, double price) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.modelName = modelName;
		this.vehicleType = vehicleType;
		this.price = price;
	}
	
	@Override
	public double issueLoan() {
		if(vehicleType.equals("4 wheeler")) {
			return price*0.8;
		}else if(vehicleType.equals("3 wheeler")) {
			return price*0.75;
		}else if(vehicleType.equals("2 wheeler")){
			return price*0.5;
		}
		return 0;
	}

	@Override
	public double takeInsurance() {
		if(price <= 150000) {
			return 3500;
		}else if(price > 150000 && price <= 300000) {
			return 4000;
		}else if(price > 300000) {
			return 5000;
		}
		return 0;
	}

}
