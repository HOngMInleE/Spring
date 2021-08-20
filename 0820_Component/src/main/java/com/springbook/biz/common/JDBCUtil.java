package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	// DB연결 메소드
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","TIGER");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB getConnection 오류");
		}
		return null;
	}// getConnection()
	
	// DB close 메소드
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB close 오류");
		}
	}// close(pstmt, conn)
	
	public static void close(PreparedStatement pstmt, Connection conn, ResultSet rs) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			if (rs != null) rs.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB close 오류");
		}
	}// close(pstmt, conn, rs)
	
	
	
	
	
	
}
