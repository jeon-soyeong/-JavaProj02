package project2.ver02;

import java.util.Scanner;

public class Account {
	
	String accountNum;
	String name;
	int balance;
	
	public Account(String accountNum, String name, int balance) {
		super();
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	
	public void depositMoney(int m){
		
	}
	
	public void showInfo(){
		System.out.println("계좌번호:"+accountNum);
		System.out.println("고객이름:"+name);
		System.out.println("잔고:"+balance);
	}
}
