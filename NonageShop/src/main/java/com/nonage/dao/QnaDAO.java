package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.QnaVO;

import util.DBManager;

public class QnaDAO {

	private QnaDAO() {
	}
	private static QnaDAO instance = new QnaDAO();
	public static QnaDAO getInstatnce() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//Read QnaList 메소드  
	public ArrayList<QnaVO> qnaList(String id) {
		String sql = "select * from qna where id=? order by qseq desc";
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVO qnaVO = new QnaVO();
				qnaVO.setQseq(rs.getInt("qseq"));
				qnaVO.setSubject(rs.getString("subject"));
				qnaVO.setContent(rs.getString("content"));
				qnaVO.setId(rs.getString("id"));
				qnaVO.setIndate(rs.getDate("indate"));
				qnaVO.setReply(rs.getString("reply"));
				qnaVO.setRep(rs.getString("rep"));
				
				qnaList.add(qnaVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("qnaList 오류");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qnaList;
	}// qnaList()
	
	
	
	
	
	
}
