package javaexam1;

import java.sql.Connection;
import java.sql.PreparedStatement;

// ����, ���������ϴ� �ڵ尡 �޼��帶�� �ߺ��Ǽ� ���Ϳ�
// Ŀ�ؼ��� ���� �������Ѵ�. �ٰ��� ��������.

public class DeptDAO {
	public void insertDept(DeptDTO deptdto) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB���� Connection ��ü�� ������ȴ�.
			conn = DBUtil.getConnection();
		
			//2. ������ �ۼ� Statement ��ü�� ������ �ȴ�.
			String sql = "insert into dept (deptno, dname, loc) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptdto.getDeptno()); //pkŰ�� ��� ���� ��������Ѵ�.
			ps.setString(2, deptdto.getDname());
			ps.setString(3, deptdto.getLoc());
		
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
	public int updateDept(DeptDTO deptdto) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. DB���� Connection ��ü�� ������ȴ�.
			conn = DBUtil.getConnection();
		
			//2. ������ �ۼ� Statement ��ü�� ������ �ȴ�.
			String sql = "update dept set dname=?, loc=?, where deptno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deptdto.getDname());
			ps.setString(2, deptdto.getLoc());
			ps.setInt(3, deptdto.getDeptno()); //pkŰ�� ��� ���� ��������Ѵ�.
		
			// 3.����
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
		// 0. �ʿ��� ��ü�� ����!!
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "delete from dept where deptno=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptdto.getDeptno());

			// 3. ��������
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
