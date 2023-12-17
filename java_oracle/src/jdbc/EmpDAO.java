package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class EmpDAO {
	public Vector listEmp(String dname) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select empno,ename,job,hiredate,sal,dname from emp e, dept d"
					+ " where e.deptno = d.deptno and dname like ?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			if (dname.equals("전체부서")) {
				dname = "%";
			}
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("empno"));
				row.add(rs.getString("ename"));
//				row.add(rs.getString(1)); 도 가능함
				row.add(rs.getString("job"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sal"));
				row.add(rs.getString("dname"));

				items.add(row);
				// 전체 벡터 행벡터
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return items;
	}
}
