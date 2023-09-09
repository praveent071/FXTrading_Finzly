package com.trading.springboot.FxTrading.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.trading.springboot.FxTrading.model.Trade;

@Service
public class TradeService {
	
	static List<Trade> list = new ArrayList<>();
	static double USDPrice = 66.00;
	static int TradeNoo=1;
	
	
	
	public boolean getbooktrade(Trade trade) {
		if(!trade.getCurrency().equalsIgnoreCase("USDINR")||trade.getAmount()<1||!ValidateString(trade.getName())) {
			return false;
			
		}else {
		trade.setTradeNo(TradeNoo++);
		double convertedprice =trade.getAmount();
		trade.setRate(USDPrice);
		trade.setConvertedamount(convertedprice*USDPrice);
		list.add(trade);
		return true;
		}
	}
				
	
	public List<Trade> getTrade() {
		return list;
	}
	
	
	public boolean ValidateString(String input) {
		if(input==""||input==null||input==".") {
			return false;
		}else {
			String regex = "^[a-zA-Z]*(\\.|[a-zA-Z  ])*$";
			return input.matches(regex);
		}
		
	}
}
