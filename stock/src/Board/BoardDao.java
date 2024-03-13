package Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnect;

public class BoardDao {
	private DBConnect db;

	public BoardDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Board b) {
		Connection conn = db.conn();

		String sql = "INSERT INTO board VALUES(seq_board.nextval, ?, sysdate, ?, ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());

			int cnt = pstmt.executeUpdate();

			System.out.println(cnt + " 개의 게시글 작성 완료");
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

	public Board select(int num) {
		Connection conn = db.conn();

		String sql = "SELECT * FROM board WHERE num = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Board(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5));
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
		return null;
	}

	public ArrayList<Board> selectByTitle(String title) {
		Connection conn = db.conn();

		String sql = "SELECT * FROM board WHERE title LIKE ? ORDER BY num";
		ArrayList<Board> list = new ArrayList<Board>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
		return list;
	}

	public ArrayList<Board> selectAll() {
		Connection conn = db.conn();

		String sql = "SELECT * FROM board ORDER BY num";

		ArrayList<Board> list = new ArrayList<Board>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
		return list;
	}

	public int update(Board b) {
		Connection conn = db.conn();

		String sql = "UPDATE board SET title = ?, content = ? WHERE num = ?";
		int cnt = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 개의 게시글 수정 완료");
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
		return cnt;
	}

	public int delete(int num) {
		Connection conn = db.conn();

		String sql = "DELETE FROM board WHERE num = ?";
		int cnt = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();

			System.out.println(cnt + " 개의 게시글 삭제 완료");
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
		return cnt;
	}

}
