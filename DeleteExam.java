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
		} // 여기에 들어가는 패키지와 클래스이름은 DB마다 다를 수 있다. 오라클, Mysql(버전에 따라 다름)

		// 2
		String url = "jdbc:mysql://localhost:3306/testdb3?serverTimezone=UTC"; // DB 회사마다 다르다. 상태를 말
		String user = "testuser";
		String password = "testpw";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // conn은 구현할 이유가 없다 이유는 인터페이스에 구현이 되어있기 때문.
			// 3
		String deptName = "이명재";
		String loc = "양주";
		String sql = "delete from dept where deptno = ?";
		// statement는 쿼리문 작성 할때 인서트할때 (')를 사용해야 해서 번거롭다.
		// 예시 : String sql = "insert into dept (deptno, dname, loc) values
		// (1,'"+test+",'test')";
		// PreparedStatement는 ??? 를 사용한다.
		// 예시 : String sql = "insert into dept (deptno, dname, loc) values (?,?,?)";

		PreparedStatement ps = null;
		// 쿼리를 넣어주는 부분
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno); // pk키를 계속 변경 시켜줘야한다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4 실행하기 select, insert, delete, update 무엇인지 구분만 하면됨
		// 쿼리문만 바꾸면 select, insert, delete, update 전부 사용할 수 있다.
		// delete
		int count;
		try {
			count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + "입력됨");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 꼭 항상 닫아줘야 한다.
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