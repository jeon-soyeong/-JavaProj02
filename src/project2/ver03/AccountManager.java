package project2.ver03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	
	Account[] accountList = new Account[50];
	int aCnt=0;
	
	Scanner scan = new Scanner(System.in);
	
	public void showMenu() throws MenuSelectException, InputMismatchException{
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	public void makeAccount() throws InputMismatchException{
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
		int inputSelect =  scan.nextInt();
		
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("고객이름:");
		String inpuName = scan.next();
		System.out.print("잔고:");
		int inputBalance = scan.nextInt();
		System.out.print("기본이자%(정수형태로입력):");
		int inputRatio = scan.nextInt();
		
		if(inputSelect==1){
			accountList[aCnt++] = new NomalAccount(inputAccountNum, inpuName, inputBalance, inputRatio);
		}
		else{
			System.out.println("신용등급(A,B,C등급):");
			String inputGrade = scan.next();
			accountList[aCnt++] = new HighCreditAccount(inputAccountNum, inpuName, inputBalance, inputRatio, inputGrade);
		}
		System.out.println("계좌개설이 완료되었습니다.");
		
	}
	public synchronized void depositMoney() throws InputMismatchException{
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("입금액:");
		int dmoney = scan.nextInt();
		
		try{
			for(int i=0; i<aCnt; i++){
				if(accountList[i].accountNum.equals(inputAccountNum)){
					if(dmoney>0 && dmoney%500==0){
						accountList[i].depositMoney(dmoney);
						System.out.println("입금이 완료되었습니다.");
						System.out.println("잔액은 "+ accountList[i].balance+"원입니다." );
					}
				}
			}
		}
		catch(NullPointerException e) {
		}
	}
	public synchronized void withdrawMoney() throws InputMismatchException{
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("출금액:");
		int wmoney = scan.nextInt();
		
		try{
			for(int i=0; i<aCnt; i++){
				if(accountList[i].accountNum.equals(inputAccountNum)){
					if(accountList[i].balance-wmoney>0){
						accountList[i].balance-=(wmoney/1000)*1000;
						System.out.println("잔액은 "+accountList[i].balance+"원입니다." );
					}
					else{
						System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요?");
						System.out.println("1.(YES), 2.(NO)");
						int inputSelect = scan.nextInt();
						if(inputSelect==1){
							accountList[i].balance=0;
							System.out.println("잔액은 "+accountList[i].balance+"원입니다." );
						}
						else{
							System.out.println("출금을 취소합니다.");
						}
					}
				}
			}
		}
		catch(NullPointerException e){
			
		}
	}
	public void showAccInfo(){
		System.out.println("***계좌정보출력***");
		System.out.println("------------------");
		for(int i =0; i<aCnt; i++){
			accountList[i].showInfo();
			System.out.println();
		}
		System.out.println("------------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
}
