package jdbc;

public class DeptDTO {
	private int deptno;
	private String dname;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + "]";
	}
	
	public DeptDTO() {
		// TODO Auto-generated constructor stub
	}
	public DeptDTO(int deptno, String dname) {
//		super();
		this.deptno = deptno;
		this.dname = dname;
	}
	
	
	
}
