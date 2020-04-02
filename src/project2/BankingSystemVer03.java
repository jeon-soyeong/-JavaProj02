package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

import project2.ver03.Account;
import project2.ver03.MenuChoice;
import project2.ver03.AccountManager;
import project2.ver03.MenuSelectException;

public class BankingSystemVer03 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		
		AccountManager accountManager =  new AccountManager();
		
		try{
			while(true){
				accountManager.showMenu();
				
				System.out.print("선택:");
				int choice =  scan.nextInt();
				System.out.println();
				
				if(!(choice==1 || choice==2 || choice==3 || choice==4 || choice==5)) {
					MenuSelectException mex = new MenuSelectException();
					throw mex;
				}
				
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
		catch(MenuSelectException e){
			System.out.println("예외발생 : 1~5 사이 숫자만 입력");
		}
		catch(InputMismatchException e){
			System.out.println("예외발생 : 문자를 입력함");
		}
	
	}

}
