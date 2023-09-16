package com.finzly.FxTrading.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.finzly.FxTrading.exception.CurrencyNotFoundException;
import com.finzly.FxTrading.exception.InvalidAmountException;
import com.finzly.FxTrading.exception.InvalidNameException;
import com.finzly.FxTrading.dao.CurrencyPairDao;
import com.finzly.FxTrading.dao.TradeDao;
import com.finzly.FxTrading.entity.CurrencyPairEntity;
import com.finzly.FxTrading.entity.TradeEntity;

@Service
public class TradeService {
	@Autowired
	private TradeDao tradedao;
	@Autowired
	private CurrencyPairDao currencypairdao;
	public String addtrade(TradeEntity tradeentity) {
			// Retrieve a list of all available currency pairs
		List<CurrencyPairEntity> list=  currencypairdao.getallCurrency();
		// Perform input validation for the tradeentity
		if(tradeentity.getAmount()<1) {
			throw new InvalidAmountException("Please enter valid amount");
		}
		if(!ValidateString(tradeentity.getName().trim())){
			throw new InvalidNameException("Please enter valid name");	
		}else {
			for (CurrencyPairEntity trade : list) {
				if(tradeentity.getCurrency().toLowerCase().equals(trade.getCurrencyname().toLowerCase())) {
					// Perform currency conversion and set trade properties
					tradeentity.setConvertedamount(tradeentity.getAmount()*trade.getCurrencyvalue());
					tradeentity.setRate(trade.getCurrencyvalue());
					tradeentity.setCurrency(trade.getCurrencyname().toUpperCase());
					tradeentity.setName(tradeentity.getName().toUpperCase());
					  // Add the trade to the database
					tradedao.addtrade(tradeentity);
					return ("Trade for "+ tradeentity.getCurrency().toUpperCase()+" has been booked with rate "+tradeentity.getRate() +" , The amount of "+tradeentity.getConvertedamount() +" will be transferred in 2 working days to "+tradeentity.getName() +".");
				}
			}
			// If no matching currency pair is found
			throw new CurrencyNotFoundException("Currencypair is not found please enter valid currencypair");
		}
	}
		//Validates a string based on the specified criteria
		public boolean ValidateString(String input) {
			if(input==""||input==null||input==".") {
				return false;
			}else {
				String regex = "^[a-zA-Z]*(\\.|[a-zA-Z  ])*$";
				return input.matches(regex);
			}
		}
		//Retrieves and returns a list of all trade entities
		public ResponseEntity<Object> showalltrade() {
			List<TradeEntity> list =  tradedao.ahowalltrade();
			if(!list.isEmpty()) {
				return new ResponseEntity<Object>(list,HttpStatus.FOUND);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT );
			}
		}
}

