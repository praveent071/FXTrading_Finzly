import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class FXTrade {
	static double USDPrice = 66.00;//Assigning values 
	static List<Trade> name = new ArrayList<>();//Creating an empty array list
	static int TradeNo=1;
	    public  static void bookTrade(Scanner sc ) {
		//Getting Customer name
		System.out.println("Enter customer Name: ");
		sc.nextLine();
		String Name  = sc.nextLine();
		String regex = "^[a-zA-Z]*(\\.|[a-zA-Z ])*$";
		if(Name.matches(regex)) {
			//CurrencyPair type
			System.out.println("Enter Currency Pair: ");
			String Currency = sc.nextLine().toUpperCase();
			//Checking the Currency type
			if(Currency.equalsIgnoreCase("usdinr")) {
				//Getting amount from the user
				System.out.println("Enter amount to transfer: ");
				int Amount = sc.nextInt();
				if(Amount >=1) {
					//Calculating the amount 
					double Number1 = Amount*USDPrice;
					NumberFormat numberFormat = NumberFormat.getInstance();
					String INR = numberFormat.format(Number1);//used to format the number with commas as thousands separators.
					System.out.println("Do you want to get Rate:(Yes/No) ");
					String Option = sc.next().toLowerCase();
					if(Option.equals("yes")) {
						System.out.println("You are transferring INR "+INR + " to "+ Name + ". (The rate was "+USDPrice + ")");
					}//else if(Option.equals("no")) {
					System.out.println("Book/Cancel this trade?:(Book/Cancel) ");
					//Asking whether trade should be book or not
					String Process = sc.next().toLowerCase();
					if(Process.equals("book")) {
						//Adding values into the list
						name.add(new Trade(TradeNo++, Currency,Name,INR ,USDPrice));
						System.out.println("Trade for USDINR has been booked with rate "+USDPrice +" , The amount of Rs "+INR  +" will  be transferred in 2 working days to "+Name +"..");
					}
					else if(Process.equals("cancel")) {
						System.out.println("Trade is Canceled. ");
					}
					else {
						System.out.println("Enter valid input");
					}
					
				}
				
			else {
				System.out.println("Enter valid amount ");
			}
				
		}
			
		else {
			System.out.println("Enter only USDINR.........");
		
			}
		}else {
			 System.out.println("Invalid name Please Enter Valid Name.");
		}
		
	}
	    static void PrintTrade() {
			System.out.println("TradeNo      CurrencyPair    CustomerName     Amount         Rate ");
			System.out.println();
			for(Trade values: name) {
				System.out.println(values);//Printing the values in the list
			}
		}
	     static void Exit(Scanner sc) {
			 System.out.println("Do you really want to exit (y/n)");
				char last = sc.next().charAt(0);
				if(last == 'y') {
					System.out.println("Bye - have a good day");
				}
				else if(last=='n'){
					Main main= new Main();
					main.looping();//Again entering into the loop
				}
				else {
					System.out.println("Enter valid input");
					Main main= new Main();
					main.looping();//Again entering into the loop
				}
		 }
	     
	     
	    

}
