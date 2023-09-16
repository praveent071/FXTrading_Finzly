package com.finzly.FxTrading.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="currencyprice")
public class CurrencyPairEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "currency_name")
	private String currencyname;
	@Column(name = "currency_value")
	private double currencyvalue;
	public CurrencyPairEntity(int id, String currencyname, double currencyvalue) {
		super();
		this.id = id;
		this.currencyname = currencyname;
		this.currencyvalue = currencyvalue;
	}
	public CurrencyPairEntity() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public double getCurrencyvalue() {
		return currencyvalue;
	}
	public void setCurrencyvalue(double currencyvalue) {
		this.currencyvalue = currencyvalue;
	}
	@Override
	public String toString() {
		return "CurrencyPairEntity [id=" + id + ", currencyname=" + currencyname + ", currencyvalue=" + currencyvalue
				+ "]";
	}
	
	

}
