package project2;

import java.util.Scanner;

import project2.ver02.Account;
import project2.ver02.MenuChoice;
import project2.ver02.AccountManager;

public class BankingSystemVer02 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		
		AccountManager accountManager =  new AccountManager();
		
		while(true){
			accountManager.showMenu();
			
			System.out.print("선택:");
			int choice =  scan.nextInt();
			System.out.println();
			
			switch(choice) {
			case MenuChoice.MAKE :
				accountManager.makeAccount();
				break;
			case MenuChoice.DEPOSIT : 
				accountManager.depositMoney();
				break;
			case MenuChoice.WITHDRAW : 
				accountManager.withdrawMoney();
				break;
			case MenuChoice.INQUIRE :
				accountManager.showAccInfo();
				break;
			case MenuChoice.EXIT :
				System.out.println("프로그램 종료");
			return;
			}
		}
	
	}

}
