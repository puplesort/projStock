package company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnection;

public class CompanyDao {
	private DBConnection dbConnection;
	public CompanyDao() {
		dbConnection = DBConnection.getInstance();
	}
	public int insert(Company c) {
		Connection conn = dbConnection.conn();
		String sql = "insert into company values(company_id,?,?,?,?,?,?,?";
		int cnt = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCompany_id());
			ps.setInt(2, c.getStock_id());
			ps.setString(3, c.getCompany_name());
			ps.setString(4, c.getCeo_name());
			ps.setDate(5, (Date) c.getFoundation_date());
			ps.setInt(6, c.getHolding());
			ps.setInt(7, c.getVolume());
			ps.setString(8, c.getInfomation());
			cnt = ps.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	public int updateInfo(Company c) {
		Connection conn = dbConnection.conn();
		String sql = "update company set company_name =?,ceo_name=?,holding=?, information=? where company_id=?";
		int cnt = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCompany_name());
			ps.setString(2,c.getCeo_name());
			ps.setInt(3, c.getHolding());
			ps.setString(4, c.getInfomation());
			ps.setInt(5, c.getCompany_id());
			cnt = ps.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	public int updateVol(Company c) {
		Connection conn = dbConnection.conn();
		String sql = "update company set volume =? where company_id = ?";
		int cnt = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getVolume());
			ps.setInt(2, c.getCompany_id());
			cnt = ps.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	public int delete(int num) {
		Connection conn = dbConnection.conn();
		String sql = "delete company where company_id = ?";
		int cnt = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	public Company findByNum(int num) {
		Connection conn = dbConnection.conn();
		String sql = "select * from company where company_id = ?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Company(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<Company> findAll() {
		Connection conn = dbConnection.conn();
		String sql = "select * from company";
		ArrayList<Company> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Company(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
