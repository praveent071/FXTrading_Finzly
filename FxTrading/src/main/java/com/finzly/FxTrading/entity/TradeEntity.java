package com.finzly.FxTrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trades")
public class TradeEntity {
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private int id;
	 @Column(name = "name")
	 private String name;
	 @Column(name = "currency")
	 private String currency;
	 @Column(name = "amount")
	 private double amount;
	 @Column(name = "convertedamount")
	 private double convertedamount;
	 @Column(name = "rate")
	 private double rate;
	 public TradeEntity() {
		
	 }
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getConvertedamount() {
		return convertedamount;
	}
	public void setConvertedamount(double convertedamount) {
		this.convertedamount = convertedamount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "TradeEntity [id=" + id + ", name=" + name + ", currency=" + currency + ", amount=" + amount
				+ ", convertedamount=" + convertedamount + ", rate=" + rate + "]";
	}
}
