package com.nonage.dao;

public class CartDAO {

//SingleTone Pattern
	private static CartDAO instance = new CartDAO();
	private CartDAO() {	}
	public static CartDAO getInstance() {
		return instance;
	}
	
	
	
	
	
}
