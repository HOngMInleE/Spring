package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nonage.dto.CartVO;

import util.DBManager;

public class CartDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
//SingleTone Pattern
	private static CartDAO instance = new CartDAO();
	private CartDAO() {	}
	public static CartDAO getInstance() {
		return instance;
	}
	
	// 장바구니에 담는 메소드(추가)
	public void insertCart(CartVO cartVO) {
		String sql = "insert into cart (cseq, id, pseq, quantity)"
				+ "values (cart_seq.nextval,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cartVO.getId());
			pstmt.setInt(2,cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertCart 오류 " + e);
		}finally {
			DBManager.close(conn, pstmt);
		}
	}// insertCart()
	
	// 상품 정보 가져오기(cartList)
	public ArrayList<CartVO> cartList(String userId) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id = ? order by cseq desc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CartVO cartVO = new CartVO();
				cartVO.setCseq(rs.getInt("cseq"));
				cartVO.setId(rs.getString("id"));
				cartVO.setPseq(rs.getInt("pseq"));
				cartVO.setMname(rs.getString("mname"));
				cartVO.setPname(rs.getString("pname"));
				cartVO.setQuantity(rs.getInt("quantity"));
				cartVO.setIndate(rs.getTimestamp("indate"));
				cartVO.setPrice2(rs.getInt("price2"));
				
				cartList.add(cartVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cartList 오류");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cartList;
	}// cartList()
	
	public void deleteCart(int cseq) {
		String sql = "delete cart where cseq = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deleteCart 오류");
		} finally {
			DBManager.close(conn, pstmt);
		}
	}//deleteCart
	
	
	
}
