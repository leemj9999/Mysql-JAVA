package javaexam1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExam {
	// 할일
	// 1. 드라이버 로딩 - 실제 구현된 클래스를 메모리에 올린다.
	// 2. DB접속하기
		//- 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
		//- Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
		//- mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
	// 3. 쿼리문 작성
	// 4. 실행하기
	
	public void insert(int deptno, String dname, String loc) {
		// 1.드라이버 로딩
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} //여기에 들어가는 패키지와 클래스 이름은 DB마다 다를 수 있다. 오라클,Mysql(버전에 따라 다름)
			
		
			
		// 2. DB접속하기
			String url = "jdbc:mysql://localhost:3306/testdb3?serverTimezone=UTC";
			String user = "testuser";
			String password = "testpw";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);
			}catch (SQLException e) {
				e.printStackTrace();
			} //conn은 구현할 이유가 없다. 이유는 인터페이스에 구현이 되어있기 때문이다.
			
			
	
		// 3. 쿼리문 작성
			String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			//statement는 쿼리문을 작성할때 인성트할때 (')를 사용해야해서 번거롭다.
			//예시 : String sql = "insert into dept(deptno, dname, loc) values (1,'"+test",'test')";
			//반면에 PreparedStatement는 ???를 사용한다.
			//예시 : String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, deptno); //pk키를 계속 변경 시켜줘야한다.
				ps.setString(2, dname);
				ps.setString(3, loc);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		// 4. 실행하기 select, insert, delete, update 무엇인지 구분만 하면됨
		// 쿼리문만 바꾸면 select, insert, delete, update 전부 사용할수 있다.
			
			//insert
			int count;
			try {
				count = ps.executeUpdate();
				if (count>0) {
					System.out.println(count + "입력됨");
				}else {
					System.out.println("입력실패");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//항상 꼭 닫아줘야한다.
				try {
					ps.close();
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
}

