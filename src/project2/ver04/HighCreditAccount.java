package project2.ver04;

public class HighCreditAccount extends Account{
	
	int hRatio;
	String grade;
	
	public HighCreditAccount(String accountNum, String name, int balance, int hRatio, String grade) {
		super(accountNum, name, balance);
		this.hRatio = hRatio;
		this.grade = grade;
	}
	
	@Override
	public void depositMoney(int m) {
		
		if(grade.contains("A")||grade.contains("a")){
			balance = balance + (balance*hRatio/100) + (balance*CustomSpecialRate.AGrade/100)+ m;
		}
		if(grade.contains("B")||grade.contains("b")){
			balance = balance + (balance*hRatio/100) + (balance*CustomSpecialRate.BGrade/100)+ m;
		}
		if(grade.contains("C")||grade.contains("c")){
			balance = balance + (balance*hRatio/100) + (balance*CustomSpecialRate.CGrade/100)+ m;
		}
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("기본이자:"+hRatio);
		System.out.println("신용등급:"+grade);
	}
	 
}
