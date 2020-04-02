package project2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import project2.ver04.Account;
import project2.ver04.MenuChoice;
import project2.ver04.AccountManager;
import project2.ver04.Game;
import project2.ver04.MenuSelectException;

public class BankingSystemVer04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		AccountManager accountManager = new AccountManager();
		Game game = new Game();
		while (true) {
			try {
				accountManager.showMenu();

				System.out.print("선택:");
				int choice = scan.nextInt();
				System.out.println();

				if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6)) {
					MenuSelectException mex = new MenuSelectException();
					throw mex;
				}

				switch (choice) {
				case MenuChoice.MAKE:
					accountManager.makeAccount();
					break;
				case MenuChoice.DEPOSIT:
					accountManager.depositMoney();
					break;
				case MenuChoice.WITHDRAW:
					accountManager.withdrawMoney();
					break;
				case MenuChoice.INQUIRE:
					accountManager.showAccInfo();
					break;
				case MenuChoice.EXIT:
					accountManager.saveAccountInfo();
					System.out.println("정상적으로 저장되었습니다.");
					return;
				case MenuChoice.GAME:
					game.play();
				}
			} catch (MenuSelectException e) {
				System.out.println("예외발생 : 1~6 사이 숫자만 입력하세요.");
			} catch (InputMismatchException e) {
				System.out.println("예외발생 : 문자를 입력하셨습니다.");
				scan.nextLine();
			} catch (Exception e) {
			}
		}
	}
}

