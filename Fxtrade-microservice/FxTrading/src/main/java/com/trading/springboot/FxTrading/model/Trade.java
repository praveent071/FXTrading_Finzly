package com.trading.springboot.FxTrading.model;

public class Trade {
	 private int tradeNo;
	 private String name;
	 private String currency;
	 private double amount;
	 private double rate;
	 private double convertedamount;
	 
	 public Trade() {
		 
	 }
	public Trade(String name, String currency, double amount) {
		super();
		this.name = name;
		this.currency = currency;
		this.amount = amount;
	}
	public int getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getConvertedamount() {
		return convertedamount;
	}
	public void setConvertedamount(double convertedamount) {
		this.convertedamount = convertedamount;
	}
	
	 
	 
	 

}
