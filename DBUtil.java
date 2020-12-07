package javaexam1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	// 1. DB 접속 -> Connection 객체 얻어오기
	
	static String URL = "jdbc:mysql://localhost:3306/testdb3?serverTimezone=UTC";
	static String USER = "testuser";
	static String PASSWORD = "testpw";
	static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	
	// 2. DB 접속종료
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
}
