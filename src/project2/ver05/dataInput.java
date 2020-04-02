package project2.ver05;

import java.util.Scanner;

public class dataInput extends IConnectImpl{
	
	public dataInput() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			String query = "INSERT INTO banking_tb VALUES (seq_banking.nextval, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("계좌번호:");
			String accountNum = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("잔고:");
			int balance =  scan.nextInt();
			
			psmt.setString(1, accountNum);
			psmt.setString(2, name);
			psmt.setInt(3, balance);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close();
		}
	}
}
