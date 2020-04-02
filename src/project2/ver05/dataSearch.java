package project2.ver05;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dataSearch extends IConnectImpl {

	public dataSearch() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM banking_tb ";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString(1);
				String accountNum = rs.getString(2);
				String name = rs.getString(3);
				String balance = rs.getString(4);

				System.out.println("==============");
				System.out.printf("아이디 : %s\n", id);
				System.out.printf("계좌번호 : %s\n", accountNum);
				System.out.printf("예금주 : %s\n", name);
				System.out.printf("잔액 : %s\n", balance);
				System.out.println("==============");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();

		}
	}

}
