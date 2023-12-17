package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ScoreDAO {

	public Vector listScore() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select student_no, name, kor, eng, mat, (kor+eng+mat) as tot, round((kor+eng+mat)/3.0,1) as avg from score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				String student_no = rs.getString("student_no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");

				row.add(student_no);
				row.add(name);
				row.add(kor);
				row.add(eng);
				row.add(mat);
				row.add(tot);
				row.add(avg);

				items.add(row);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	public int insertScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.oraConn();
			String sql = "insert into score values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return result;
	}

	public int updateScore(ScoreDTO dto) {
		int results = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		;

		return results;
	}
}
