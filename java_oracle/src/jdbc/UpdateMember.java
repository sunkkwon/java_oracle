package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateMember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "kwon";
		String pwd = "9257";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			Scanner scan = new Scanner(System.in);

			System.out.println("아이디를 입력하세요");
			String userid = scan.next();

			System.out.println("변경할 비밀번호를 입력하세요");
			String passwd = scan.next();
			String sql = "update member set passwd = ? where userid = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, passwd);
			pstmt.setString(2, userid);

			int rows = pstmt.executeUpdate();

			if (rows > 0) {
				System.out.println("[" + userid + "]" + " 가 수정 되었습니다");
			}
			System.out.println("[" + userid + "]" + "를 확인 하세요");
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
