package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMember {

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

			System.out.println("아이디: ");
			String userid = scan.next();

			System.out.println("비밀번호: ");
			String passwd = scan.next();

			System.out.println("이름: ");
			String name = scan.next();

			System.out.println("이메일: ");
			String email = scan.next();
			
			String sql = "insert into member (userid,passwd,name,email) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);

			pstmt.executeUpdate();
			System.out.println("레코드가 추가 되었습니다.");
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
