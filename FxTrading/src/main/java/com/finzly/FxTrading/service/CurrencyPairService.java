package com.finzly.FxTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FxTrading.dao.CurrencyPairDao;
import com.finzly.FxTrading.entity.CurrencyPairEntity;

@Service
public class CurrencyPairService {
	@Autowired
	private CurrencyPairDao currencypairdao;

	public String addcurrency(CurrencyPairEntity currencypair) {
		return currencypairdao.addcurrency(currencypair);
	}

	public ResponseEntity<Object> getallcurrency() {
		List<CurrencyPairEntity> list =  currencypairdao.getallcurrency();
		if(!list.isEmpty()) {
			return new ResponseEntity<Object>(list,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}

	public String getupdate(int id, CurrencyPairEntity currencypair) {
		return currencypairdao.getupdate(id,currencypair);
	}

	public String getdeletecurrency(int id, CurrencyPairEntity currencypair) {
		return currencypairdao.getdeletecurrency(id,currencypair);
	}

}
