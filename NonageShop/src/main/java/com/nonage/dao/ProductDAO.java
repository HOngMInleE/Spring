package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		 return instance;
	}
	
	
	//New Item
	public ArrayList<ProductVO> listNewProduct(){
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql= "select * from new_pro_view";
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	    	  	ProductVO product = new ProductVO(); // 불러온 데이터 저장할 VO객체 생성
				product.setPseq(rs.getInt("pseq")); // DB에서 불러와 VO에 저장
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product); // List에 VO 객체 저장
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("listNewProduct()오류 ");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		
		return productList;	
	}// listNewProduct()
	
	//Best Item / listNewProduct()와 동일
	public ArrayList<ProductVO> listBestProduct() {
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql= "select * from best_pro_view";
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	    	  	ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("listBestProduct()오류 ");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		
		return productList;	
	}// listBestProduct() / listNewProduct()와 동일
	
	// 상세정보 확인 메소드 
	public ProductVO getProduct(String pseq) {
		
		String sql = "select * from product where pseq = ?";
		ProductVO product = null;
		
		try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, pseq);
		      rs = pstmt.executeQuery();
		      if(rs.next()) {
		    	  product = new ProductVO();
		          product.setPseq(rs.getInt("pseq"));
		          product.setName(rs.getString("name"));
		          product.setKind(rs.getString("kind"));
		          product.setPrice1(rs.getInt("price1"));
		          product.setPrice2(rs.getInt("price2"));
		          product.setPrice3(rs.getInt("price3"));
		          product.setContent(rs.getString("content"));
		          product.setImage(rs.getString("image"));
		          product.setUseyn(rs.getString("useyn"));
		          product.setBestyn(rs.getString("bestyn"));
		          product.setIndate(rs.getTimestamp("indate")); 
		      }
			} catch (Exception e) {
			      e.printStackTrace();
			      System.out.println("getProduct()오류 ");
			} finally {
			  DBManager.close(conn, pstmt, rs);
			}
		
		return product;
	}// getProduct()
	
	public ArrayList<ProductVO> listKindProduct(String kind){
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql= "select * from product where kind = ?";
		
		try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, kind);
		      rs = pstmt.executeQuery();
		      
		      while (rs.next()) {
		          ProductVO product = new ProductVO();
		          product.setPseq(rs.getInt("pseq"));
		          product.setName(rs.getString("name"));
		          product.setPrice2(rs.getInt("price2"));
		          product.setImage(rs.getString("image"));
		          productList.add(product);
		      }		      
		} catch (Exception e) {
		      e.printStackTrace();
		      System.out.println("listKindProduct()오류 ");
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}// listKindProduct()
	
}// publicDAO end
