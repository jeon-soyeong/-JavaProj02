package project2;

import java.util.Scanner;

import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		
		Account account = new Account();
		
		while(true){
			account.showMenu();
			
			System.out.print("선택:");
			int choice =  scan.nextInt();
			System.out.println();
			
			switch(choice) {
			case MenuChoice.MAKE :
				account.makeAccount();
				break;
			case MenuChoice.DEPOSIT : 
				account.depositMoney();
				break;
			case MenuChoice.WITHDRAW : 
				account.withdrawMoney();
				break;
			case MenuChoice.INQUIRE :
				account.showAccInfo();
				break;
			case MenuChoice.EXIT :
				System.out.println("프로그램 종료");
			return;
			}
		}
	
	}

}
