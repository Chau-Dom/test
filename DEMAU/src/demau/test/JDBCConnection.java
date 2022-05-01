package demau.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	/**
	 * hàm này để tạo connection tới SQL
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DE_MAU;user=sa;password=123456789";
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("Kết nối thành công!");
		} catch (SQLException e) {
			System.out.println("Kết nối không thành công!");
		}
		return conn;
	}

	public static void closeConn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Lỗi hệ thống do: " + e.getMessage());
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("Lỗi hệ thống do: " + e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Lỗi hệ thống do: " + e.getMessage());
			}
		}
	}
}
