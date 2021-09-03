package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nonage.dto.CartVO;

import util.DBManager;

public class OrderDAO {

	private static OrderDAO instance = new OrderDAO();
	private OrderDAO() {
	}
	public static OrderDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 주문하기에 담기
	public int insertOrder(ArrayList<CartVO> cartList, String id) {
		int maxOseq = 0;
		try {
			conn = DBManager.getConnection();
			String insertOrder = "insert into Orders (oseq, id) values(orders_seq.nextval,?)";
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			
			String selectMaxOseq = "select max(oseq) from orders";
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				maxOseq = rs.getInt(1); // 얻어온 값이 1개라 1만작성.
			}
			for (CartVO cartVO : cartList) {
				insertOrderDetail(cartVO,maxOseq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertOrder() 오류");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return maxOseq;
	}// insertOrder()
	
	private void insertOrderDetail(CartVO cartVO, int maxOseq) {
		String insertOrderDetail = "insert into order_detail(odseq,oseq,pseq,quantity)"
				+ " values (order_detail_seq.nextval,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			pstmt.executeQuery();
			
			pstmt.close();
			
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cartVO.getCseq());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertOrderDetail() 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}// insertOrderDetail()
	
	
	
	
	
	
	
	
	
	
	
	
	
}