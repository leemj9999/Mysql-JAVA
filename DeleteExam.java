package javaexam1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {

	public void delete(int deptno) {
		// 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ���⿡ ���� ��Ű���� Ŭ�����̸��� DB���� �ٸ� �� �ִ�. ����Ŭ, Mysql(������ ���� �ٸ�)

		// 2
		String url = "jdbc:mysql://localhost:3306/testdb3?serverTimezone=UTC"; // DB ȸ�縶�� �ٸ���. ���¸� ��
		String user = "testuser";
		String password = "testpw";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // conn�� ������ ������ ���� ������ �������̽��� ������ �Ǿ��ֱ� ����.
			// 3
		String deptName = "�̸���";
		String loc = "����";
		String sql = "delete from dept where deptno = ?";
		// statement�� ������ �ۼ� �Ҷ� �μ�Ʈ�Ҷ� (')�� ����ؾ� �ؼ� ���ŷӴ�.
		// ���� : String sql = "insert into dept (deptno, dname, loc) values
		// (1,'"+test+",'test')";
		// PreparedStatement�� ??? �� ����Ѵ�.
		// ���� : String sql = "insert into dept (deptno, dname, loc) values (?,?,?)";

		PreparedStatement ps = null;
		// ������ �־��ִ� �κ�
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno); // pkŰ�� ��� ���� ��������Ѵ�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4 �����ϱ� select, insert, delete, update �������� ���и� �ϸ��
		// �������� �ٲٸ� select, insert, delete, update ���� ����� �� �ִ�.
		// delete
		int count;
		try {
			count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + "�Էµ�");
			} else {
				System.out.println("�Է� ����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �� �׻� �ݾ���� �Ѵ�.
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}