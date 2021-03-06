package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleBoard");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	//글의 개수 구하기
	public int getListCount() {
		int num = 0;
		try {
			String sql = "select count(*) from board";
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1); // 전체 행의 개수 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getListCount() 오류");
		} finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// finally
		return num;
	}
	
	
	//글 목록 보기
	public List<BoardBean> getBoardList(){
		String sql = "select board_num, board_name, board_subject, board_content,"
				+ "board_file, board_readcount, board_date " 
				+ "from BOARD order by BOARD_NUM desc";
		List<BoardBean> list = new ArrayList<BoardBean>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				BoardBean bVo = new BoardBean();
				bVo.setNum(rs.getInt("BOARD_NUM"));
				bVo.setName(rs.getString("BOARD_NAME"));
				bVo.setPass(rs.getString("BOARD_PASS"));
				bVo.setSubject(rs.getString("BOARD_SUBJECT"));
				bVo.setContent(rs.getString("BOARD_CONTENT"));
				bVo.setFile(rs.getString("BOARD_FILE"));
				bVo.setReadcount(rs.getInt("BOARD_READCOUNT"));
				bVo.setDate(rs.getDate("BOARD_DATE"));
				list.add(bVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("getBoardList() 오류");
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// finally
		return list;
	}
	
	//글 내용 보기.
	public BoardBean getDetail(int num) throws Exception{
		String sql = "select * from board where board_num = ?";
		BoardBean bVo = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 한개의 글,행에 대한 조회 if사용
				bVo = new BoardBean();
				bVo.setNum(rs.getInt("BOARD_NUM"));
				bVo.setName(rs.getString("BOARD_NAME"));
				bVo.setSubject(rs.getString("BOARD_SUBJECT"));
				bVo.setContent(rs.getString("BOARD_CONTENT"));
				bVo.setFile(rs.getString("BOARD_FILE"));
				bVo.setReadcount(rs.getInt("BOARD_READCOUNT"));
				bVo.setDate(rs.getDate("BOARD_DATE"));
			}
		}catch (Exception e) {
			System.out.println("getDetail() 오류" + e);
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// finally
		return bVo;
	}// getDetail()
	
	//글 등록
	public boolean boardInsert(BoardBean board){
		String sql = "insert into board(name, pass, subject, content, file)"
				+ "values (?, ?, ?, ?, ?)";
		boolean result = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPass());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFile());

			pstmt.executeUpdate(); // 데이터베이스 갱신 / 값을 업데이트함.(저장시킴)
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// finally
		return result;
	}// boardInsert()
	

	//조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception{
		String sql = 
				"update board set board_readcount = "
				+ "board_readcount + 1 where board_num = " + num;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("setReadCountUpdate 오류" + e);
		}finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("조회수 불러오기 오류");
			}
		}//finally
	}// setReadCountUpdate()


}
	