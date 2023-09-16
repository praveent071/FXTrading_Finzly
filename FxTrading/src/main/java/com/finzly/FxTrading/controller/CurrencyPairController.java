package com.finzly.FxTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FxTrading.entity.CurrencyPairEntity;
import com.finzly.FxTrading.service.CurrencyPairService;
@RestController
@RequestMapping("currency")
public class CurrencyPairController {
	@Autowired
	private CurrencyPairService currencypairservice;
	
	//Request for adding a new currency
	@PostMapping("addcurrency")
	public String addcurrency(@RequestBody CurrencyPairEntity currencypair) {
		return currencypairservice.addcurrency(currencypair);
		
	}
	
	//Request to retrieve and display all trades
	@GetMapping("allcurrency")
	public ResponseEntity<Object> getallcurrency(){
		return currencypairservice.getallcurrency();
	}
	
	//Request to update currency and price information for a specific currency pair
	@PutMapping("updatecurrency/{id}")
	public String getupdate(@PathVariable int id,@RequestBody CurrencyPairEntity currencypair){
		return currencypairservice.getupdate(id,currencypair);
	}
	
	//Request to delete a currency pair by its unique identifier
	@DeleteMapping("deletecurrency/{id}")
	public String getdeletecurrency(@PathVariable int id,@RequestBody CurrencyPairEntity currencypair){
		return currencypairservice.getdeletecurrency(id,currencypair);
	}

}
