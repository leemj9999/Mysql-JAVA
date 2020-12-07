package javaexam1;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 접속, 접속종료하는 코드가 메서드마다 중복되서 나와요
// 커넥션은 각각 만들어야한다. 다같이 쓸수없다.

public class DeptDAO {
	public void insertDept(DeptDTO deptdto) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB접속 Connection 객체를 얻어오면된다.
			conn = DBUtil.getConnection();
		
			//2. 쿼리문 작성 Statement 객체를 얻어오면 된다.
			String sql = "insert into dept (deptno, dname, loc) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptdto.getDeptno()); //pk키를 계속 변경 시켜줘야한다.
			ps.setString(2, deptdto.getDname());
			ps.setString(3, deptdto.getLoc());
		
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
	public int updateDept(DeptDTO deptdto) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB접속 Connection 객체를 얻어오면된다.
			conn = DBUtil.getConnection();
		
			//2. 쿼리문 작성 Statement 객체를 얻어오면 된다.
			String sql = "update dept set dname=?, loc=?, where deptno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deptdto.getDname());
			ps.setString(2, deptdto.getLoc());
			ps.setInt(3, deptdto.getDeptno()); //pk키를 계속 변경 시켜줘야한다.
		
			// 3.실행
			count = ps.executeUpdate();
			
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.close(conn,ps);
		}
		return count;
	}
	
	
	
	public boolean deleteDept(DeptDTO deptdto) {
		boolean resultFlag = false;
		// 0. 필요한 객체를 선언!!
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "delete from dept where deptno=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptdto.getDeptno());

			// 3. 쿼리실행
			int count = ps.executeUpdate();
			if (count > 0)
				resultFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}

		return resultFlag;
	}
}
