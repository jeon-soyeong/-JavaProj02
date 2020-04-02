package project2.ver04;

public class NomalAccount extends Account {
	
	int nRatio;
	
	public NomalAccount(String accountNum, String name, int balance, int nRatio) {
		super(accountNum, name, balance);
		this.nRatio = nRatio;
	}
	
	@Override
	public void depositMoney(int m) {
		balance = balance + (balance*nRatio/100) + m;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("기본이자:"+nRatio);
	}
}
