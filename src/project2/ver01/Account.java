package project2.ver01;

import java.util.Scanner;

public class Account {
	
	String accountNum;
	String name;
	int balance;
	
	Account[] accountList = new Account[50];
	int aCnt=0;
	
	public Account() {}
	public Account(String accountNum, String name, int balance) {
		super();
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void showMenu(){
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	public void makeAccount(){
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("고객이름:");
		String inpuName = scan.next();
		System.out.print("잔고:");
		int inputBalance = scan.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		
		accountList[aCnt++] = new Account(inputAccountNum, inpuName, inputBalance);
	}
	public synchronized void depositMoney(){
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호:");
		String inputAccountNum = scan.next();
		System.out.print("입금액:");
		int dmoney = scan.nextInt();
		
		try{
			for(int i=0; i<aCnt; i++){
				if(accountList[i].accountNum.equals(inputAccountNum)){
					accountList[i].balance +=dmoney;
					System.out.println("입금이 완료되었습니다.");
					System.out.println("잔액은 "+accountList[i].balance+"원입니다." );
				}
			}
		}
		catch(NullPointerException e){
			
		}
	}
	public synchronized void withdrawMoney(){
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
						accountList[i].balance-=wmoney;
						System.out.println("잔액은 "+accountList[i].balance+"원입니다." );
					}
					else{
						System.out.println("잔고가 부족합니다.");
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
		for(int i=0; i<aCnt; i++){
			System.out.println("계좌번호:"+accountList[i].accountNum);
			System.out.println("고객이름:"+accountList[i].name);
			System.out.println("잔고:"+accountList[i].balance);
		}
		System.out.println("------------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
}
