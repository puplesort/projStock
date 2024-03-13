package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnect.DBConnect;
import Trade.Trade;

public class AccountDao {
	private DBConnect db;

	public AccountDao() {
		db = DBConnect.getInstance();
	}
	public void inset(Account a) {
		Connection conn = db.conn();
		String sql = "insert into Account values(?,?,?,?)";
		try {
			PreparedStatement ptsmt = conn.prepareStatement(sql);
			ptsmt.setString(1, a.getAccountNumber());
			ptsmt.setInt(2, a.getBankId());
			ptsmt.setInt(3, a.getCash());
			ptsmt.setString(4, a.getBankName());
			int i = ptsmt.executeUpdate();
			if (i < 1) {
				System.out.println("실행 실패!");
			} else {
				System.out.println("실행 완료!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
