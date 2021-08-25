package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		Context initContext;
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("getConnection Naming 오류 " + e);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("getConnection SQL 오류 " + e);
		}
		return conn;
	} // getConnection()
	
	public static void close(Connection conn,Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("close 오류 " + e);
		}
	}// close(conn, stmt, rs)
	
	// 오버로딩이용 , rs가 없을 때.
	public static void close(Connection conn,Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("close 오류 " + e);
		}
	}// close (conn, stmt)
}
