package project2;

import java.util.Scanner;

import project2.ver05.MenuChoice;
import project2.ver05.dataInput;
import project2.ver05.dataSearch;
import project2.ver05.dataPlusUpdate;
import project2.ver05.dataMinUpdate;

public class BankingSystemVer05 implements MenuChoice{

	
	public static void showMenu() {
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true){
			showMenu();
			
			System.out.print("선택:");
			int choice =  scan.nextInt();
			System.out.println();
			
			switch(choice) {
			case MAKE :
				new dataInput().execute();
				break;
			case DEPOSIT : 
				new dataPlusUpdate().execute();
				break;
			case WITHDRAW : 
				new dataMinUpdate().execute();
				break;
			case INQUIRE :
				new dataSearch().execute();
				break;
			case EXIT :
				System.out.println("프로그램 종료");
			return;
			}
		}
	
	}

}
