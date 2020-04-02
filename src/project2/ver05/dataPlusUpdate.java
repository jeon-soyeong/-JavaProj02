package project2.ver05;

import java.sql.SQLException;

public class dataPlusUpdate extends IConnectImpl {

	public dataPlusUpdate() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		String sql = "UPDATE banking_tb " + "SET balance=balance+? WHERE accountNum=?";
		try {
			psmt = con.prepareStatement(sql);

			psmt.setString(2, scanValue("계좌번호"));
			psmt.setString(1, scanValue("잔고"));

			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 업데이트 되었습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

}
