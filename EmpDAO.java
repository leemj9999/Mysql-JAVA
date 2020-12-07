package javaexam1;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 접속, 접속종료하는 코드가 메서드마다 중복되서 나와요
// 커넥션은 각각 만들어야한다. 다같이 쓸수없다.

public class EmpDAO {
	public void insertEmp(EmpDTO empdto) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB접속 Connection 객체를 얻어오면된다.
			conn = DBUtil.getConnection();
		
			//2. 쿼리문 작성 Statement 객체를 얻어오면 된다.
			String sql = "insert into emp (empno, ename,job,mgr,hiredate,sal,comm,deptno) values (?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empdto.getEmpno()); //pk키를 계속 변경 시켜줘야한다.
			ps.setString(2, empdto.getEname());
			ps.setString(3, empdto.getJob());
			ps.setString(4, empdto.getMgr());
			ps.setString(5, empdto.getHiredate());
			ps.setString(6, empdto.getSal());
			ps.setString(7, empdto.getComm());
			ps.setInt(8, empdto.getDeptno());
			// 3.실행
			int count = ps.executeUpdate();
			if (count>0) {
				System.out.println(count + "건 입력 성공!!");
			}else {
				System.out.println("입력실패!!!");
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.close(conn,ps);
		}
	}
	public int updateEmp(EmpDTO empdto) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB접속 Connection 객체를 얻어오면된다.
			conn = DBUtil.getConnection();
	
			//2. 쿼리문 작성 Statement 객체를 얻어오면 된다.
			String sql = "update emp set ename = ?, job = ?, mgr= ?,hiredate = ?,sal = ?,comm = ?,deptno = ? where empno =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, empdto.getEname());
			ps.setString(2, empdto.getJob());
			ps.setString(3, empdto.getMgr());
			ps.setString(4, empdto.getHiredate());
			ps.setString(5, empdto.getSal());
			ps.setString(6, empdto.getComm());
			ps.setInt	(7, empdto.getDeptno());
			ps.setInt	(8, empdto.getEmpno());
			// 3.실행
			count = ps.executeUpdate();
			
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.close(conn,ps);
		}
		return count;
	}
	
	
	public boolean deleteEmp(EmpDTO empdto) {
		boolean resultFlag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno = ?";
		try {
			// 1. DB접속 Connection 객체를 얻어오면된다.
			conn = DBUtil.getConnection();
			//2. 쿼리문 작성 Statement 객체를 얻어오면 된다.
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empdto.getEmpno());
			// 3.실행
			int count = ps.executeUpdate();
			if (count>0)
				resultFlag = true;
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.close(conn,ps);
		}
		return resultFlag;
	}
}
	
	
	

