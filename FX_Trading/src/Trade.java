public class Trade{
	 private int TradeNo;
	 private String Currency;
	 private String Name;
	 private double Amount;
	 private String INR;
	public Trade(int TradeNo,String Currency,String Name,String INR,double Amount){
		this.TradeNo = TradeNo;
		this.Currency=Currency;
		this.Name=Name;
		this.Amount=Amount;
		this.INR=INR;
	}
	

	@Override
	public String toString() {
		return String.format("%-15s %-13s %-15s INR%-14s %-10s" , TradeNo,Currency,Name,INR,Amount);
	}
	
	
}
	
	
	
		
		
		
		
			
		
	



