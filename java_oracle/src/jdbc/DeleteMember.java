package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "kwon";
		String pw = "9257";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			Scanner scan = new Scanner(System.in);

			System.out.println("삭제항 ID: ");
			String userid = scan.next();
			String sql = "delete from member where userid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("레코드 " + userid + " 가 삭제 되었습니다.");
			} else
				System.out.println("[" + userid + "]" + " 삭제할 레코드가 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
