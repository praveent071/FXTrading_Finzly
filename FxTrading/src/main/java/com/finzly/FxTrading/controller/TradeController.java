package com.finzly.FxTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.FxTrading.entity.TradeEntity;
import com.finzly.FxTrading.service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {
	@Autowired
	private TradeService tradeservice;
	
	//Request for adding a new trade
	@PostMapping("addtrade")
	public String addtrade(@RequestBody TradeEntity tradeentity) {
		return tradeservice.addtrade(tradeentity);
	}
	
	//Request to retrieve and display all trades
	@GetMapping("alltrade")
	public ResponseEntity<Object> ahowalltrade(){
		return tradeservice.showalltrade();
	}
}
