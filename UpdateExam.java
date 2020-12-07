package javaexam1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExam{
	// ����
		// 1. ����̹� �ε� - ���� ������ Ŭ������ �޸𸮿� �ø���.
		// 2. DB�����ϱ�
			//- ����̹� �Ŵ������� Connection ��ü�� �޶�� ��û�Ѵ�.
			//- Connection�� ��� ���� �ʿ��� url ����, �����縶�� �ٸ���.
			//- mysql�� "jdbc:mysql://localhost/�����db�̸�" �̴�.
		// 3. ������ �ۼ�
		// 4. �����ϱ�
	
	public void update(int deptno, String dname, String loc) {
		// 1. ����̹� �ε� 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // ���⿡ ���� ��Ű���� Ŭ���� �̸��� DB���� �ٸ� �� �ִ�. ����Ŭ, Mysql(������ ���� �ٸ�)
		
		
		
		// 2. DB�����ϱ�
		String url = "jdbc:mysql://localhost:3306/testdb3?serverTimezone=UTC";
		String user = "testuser";
		String password = "testpw";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		} //conn�� ������ ������ ����. ������ �������̽��� ������ �Ǿ��ֱ� �����̴�.
		
		
		
		// 3. ������ �ۼ�
		String sql = "update dept set dname = ?, loc = ? where deptno =?";
		//statement�� �������� �ۼ��Ҷ� �μ�Ʈ�Ҷ� (')�� ����ؾ��ؼ� ���ŷӴ�.
		//���� : String sql = "insert into dept(deptno, dname, loc) values (1,'"+test",'test')";
		//�ݸ鿡 PreparedStatement�� ???�� ����Ѵ�.
		//���� : String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
		
		PreparedStatement ps = null;
		// ������ �־��ִ� �κ�
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.setInt(3, deptno);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		// 4. �����ϱ� select, insert, delete, update �������� ���и� �ϸ��
		// �������� �ٲٸ� select, insert, delete, update ���� ����Ҽ� �ִ�.
		
		//delete
		int count;
		try {
			count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + "�Էµ�");
			}else {
				System.out.println("�Է� ����");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// �׻� �� �ݾ�����Ѵ�.
			try {
				ps.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}