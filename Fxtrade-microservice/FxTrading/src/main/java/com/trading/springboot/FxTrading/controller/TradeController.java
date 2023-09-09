package com.trading.springboot.FxTrading.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trading.springboot.FxTrading.model.Trade;
import com.trading.springboot.FxTrading.service.TradeService;

@RestController
@RequestMapping("FXTrade")
public class TradeController {
	
	@Autowired TradeService tradeService;
	
	@PostMapping("book")//For booking trades
	public String getbooktrade(@RequestBody Trade trade) {
		if(!tradeService.getbooktrade(trade)) {
			return "Please enter correct input only";
			
		}else {
		
		return ("Trade for USDINR has been booked with rate "+trade.getRate() +" , The amount of Rs "+trade.getConvertedamount()  +" will  be transferred in 2 working days to "+trade.getName() +"..");
		}
	}
		
		
				
	
	@GetMapping("list")//For showing the list of trades
	public ResponseEntity<Object> getTrade() {
		List<Trade> list = tradeService.getTrade();
		if(list.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT );
		}
		else {
			return new ResponseEntity<Object>(list,HttpStatus.FOUND);
		}
	}
	
	@GetMapping("Exit")//For exiting the operation
	public void getExit() {
	
		System.exit(0);
	
	}

}
