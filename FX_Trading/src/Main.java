import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		looping();//Initialization of looping method
		
	}
	    static void looping() {
		boolean loop = false;
		while(!loop) {
		System.out.println("| Book Trade  - 1 \n| Book Trades - 2  \n| Exit        - 3");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 or 2 or 3: ");
		if (sc.hasNextInt()) {
			int Number = sc.nextInt();
			if(Number==1) {
				FXTrade book = new FXTrade();
				book.bookTrade(sc);//Calling bookTrade Method
	
			}
			else if(Number==2) {
				FXTrade book2 = new FXTrade();
				book2.PrintTrade();//Calling PrintTrade Method
			}
			else if (Number==3) {
				FXTrade book3 = new FXTrade();
				book3.Exit(sc);//Calling Exit Method
				return;
			}
			else {
				System.out.println("Invalid Option Entered.Enter between 1 to 3 ");
			}
		}
		else {
			 System.out.println("Invalid input. Please enter a valid integer.");
		}
		}

	}
}

	


			



