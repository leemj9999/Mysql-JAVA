package javaexam1;

import java.sql.Connection;
import java.sql.PreparedStatement;

// ����, ���������ϴ� �ڵ尡 �޼��帶�� �ߺ��Ǽ� ���Ϳ�
// Ŀ�ؼ��� ���� �������Ѵ�. �ٰ��� ��������.

public class EmpDAO {
	public void insertEmp(EmpDTO empdto) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB���� Connection ��ü�� ������ȴ�.
			conn = DBUtil.getConnection();
		
			//2. ������ �ۼ� Statement ��ü�� ������ �ȴ�.
			String sql = "insert into emp (empno, ename,job,mgr,hiredate,sal,comm,deptno) values (?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empdto.getEmpno()); //pkŰ�� ��� ���� ��������Ѵ�.
			ps.setString(2, empdto.getEname());
			ps.setString(3, empdto.getJob());
			ps.setString(4, empdto.getMgr());
			ps.setString(5, empdto.getHiredate());
			ps.setString(6, empdto.getSal());
			ps.setString(7, empdto.getComm());
			ps.setInt(8, empdto.getDeptno());
			// 3.����
			int count = ps.executeUpdate();
			if (count>0) {
				System.out.println(count + "�� �Է� ����!!");
			}else {
				System.out.println("�Է½���!!!");
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
			// 1. DB���� Connection ��ü�� ������ȴ�.
			conn = DBUtil.getConnection();
	
			//2. ������ �ۼ� Statement ��ü�� ������ �ȴ�.
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
			// 3.����
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
			// 1. DB���� Connection ��ü�� ������ȴ�.
			conn = DBUtil.getConnection();
			//2. ������ �ۼ� Statement ��ü�� ������ �ȴ�.
			ps = conn.prepareStatement(sql);
			ps.setInt(1,empdto.getEmpno());
			// 3.����
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
	
	
	

