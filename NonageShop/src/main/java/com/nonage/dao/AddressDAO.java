package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nonage.dto.AddressVO;

import util.DBManager;

public class AddressDAO {

// SingleTornPattern
	private static AddressDAO instance = new AddressDAO();
	private AddressDAO() {
	}
	public static AddressDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// dong을 매개값으로 주소검색
	public List<AddressVO> selectAddressByDong(String dong) {
		// TODO Auto-generated method stub
		List<AddressVO> addressList = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%' ";
												// 공백들어가지않게 붙여서 사용
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AddressVO address = new AddressVO();
				address.setZipNum(rs.getString("zip_num"));
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setZipCode(rs.getString("zip_code"));
				address.setBunji(rs.getString("bunji"));
				
				addressList.add(address);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectAddressByBond 오류");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return addressList;
	}// selectAddressByDong()
	
	
}
