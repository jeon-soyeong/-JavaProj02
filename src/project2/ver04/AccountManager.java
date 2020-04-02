package project2.ver04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager {
	
	public AccountManager() {
		showAccountInfo();
	}
	
	HashSet<Account> hashSet = new HashSet<Account>();
	int aCnt = 0;

	Scanner scan = new Scanner(System.in);

	public void showMenu() throws MenuSelectException, InputMismatchException {
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.println("6.3by3 게임실행");
	}

	public void makeAccount() throws InputMismatchException {
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
		int inputSelect = scan.nextInt();

		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("고객이름:");
		String inpuName = scan.next();
		System.out.print("잔고:");
		int inputBalance = scan.nextInt();
		System.out.print("기본이자%(정수형태로입력):");
		int inputRatio = scan.nextInt();

		if (inputSelect == 1) {
			Account account = new NomalAccount(inputAccountNum, inpuName, inputBalance, inputRatio);
			boolean flag = hashSet.add(account);
			if (flag == false) {
				System.out.println("이미 존재하는 사람입니다.");
				System.out.println("덮어쓰시겠습니까? 1.(네), 2.(아니오)");

				int inputOver = scan.nextInt();
				if (inputOver == 1) {
					hashSet.remove(account);
					hashSet.add(account);
				}
			} else {
				hashSet.add(account);
			}
		} else {
			System.out.print("신용등급(A,B,C등급):");
			String inputGrade = scan.next();
			Account account = new HighCreditAccount(inputAccountNum, inpuName, inputBalance, inputRatio, inputGrade);
			boolean flag = hashSet.add(account);
			if (flag == false) {
				System.out.println("이미 존재하는 사람입니다.");
				System.out.println("덮어쓰시겠습니까? 1.(네), 2.(아니오)");

				int inputOver = scan.nextInt();
				if (inputOver == 1) {
					hashSet.remove(account);
					hashSet.add(account);
				}
			} else {
				hashSet.add(account);
			}
		}
		System.out.println("계좌개설이 완료되었습니다.");
	}

	public synchronized void depositMoney() throws InputMismatchException {
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("입금액:");
		int dmoney = scan.nextInt();

		try {
			Iterator<Account> itr = hashSet.iterator();
			while (itr.hasNext()) {
				Account object = itr.next();
				if (object.accountNum.equals(inputAccountNum)) {
					if (dmoney > 0 && dmoney % 500 == 0) {
						object.depositMoney(dmoney);
						System.out.println("입금이 완료되었습니다.");
						System.out.println("잔액은 " + object.balance + "원입니다.");
					}
				}
			}
		} catch (NullPointerException e) {
		}
	}

	public synchronized void withdrawMoney() throws InputMismatchException {
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("출금액:");
		int wmoney = scan.nextInt();

		try {
			Iterator<Account> itr = hashSet.iterator();
			while (itr.hasNext()) {
				Account object = itr.next();
				if (object.accountNum.equals(inputAccountNum)) {
					if (object.balance - wmoney > 0) {
						object.balance -= (wmoney / 1000) * 1000;
						System.out.println("잔액은 " + object.balance + "원입니다.");
					} else {
						System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요?");
						System.out.println("1.(YES), 2.(NO)");
						int inputSelect = scan.nextInt();
						if (inputSelect == 1) {
							object.balance = 0;
							System.out.println("잔액은 " + object.balance + "원입니다.");
						} else {
							System.out.println("출금을 취소합니다.");
						}
					}
				}
			}
		} catch (NullPointerException e) {
		}
	}

	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("------------------");
		Iterator<Account> itr = hashSet.iterator();
		while (itr.hasNext()) {
			itr.next().showInfo();
			System.out.println("------------------");
		}
		System.out.println("***전체계좌정보 출력이 완료되었습니다.***");
	}

	public void saveAccountInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/project2/ver04/AccountBook.obj"));
			Iterator<Account> itr = hashSet.iterator();
			while (itr.hasNext()) {
				out.writeObject(itr.next());
			}
		} catch (Exception e) {
			System.out.println("예외발생");
		}
	}

	public void showAccountInfo() {

		try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/project2/ver04/AccountBook.obj"));
			
			while (true) {
				// 저장된 파일에서 정보 1개 읽어오기
				Account account = (Account) in.readObject();
				// 만약 읽어올 정보(객체)가 더이상 없다면 루프 탈출
				if (account == null)
					break;
				hashSet.add(account);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("예외발생 : 클래스를 찾을 수 없습니다.");
		} 
		catch (FileNotFoundException e) {
			System.out.println("예외발생 : 파일을 찾을 수 없습니다.");
		}
		catch (IOException e) {
		}
	}

}
