package project2.ver04;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Account implements Serializable{
	
	String accountNum;
	String name;
	int balance;
	
	public Account(String accountNum, String name, int balance) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNum == null) ? 0 : accountNum.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Account account = (Account)obj;
		if(account.accountNum.equals(this.accountNum)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
}
