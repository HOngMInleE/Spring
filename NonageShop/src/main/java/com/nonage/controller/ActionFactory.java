package com.nonage.controller;

import com.nonage.controller.action.Action;
import com.nonage.controller.action.CartDeleteAction;
import com.nonage.controller.action.CartInsertAction;
import com.nonage.controller.action.CartListAction;
import com.nonage.controller.action.ContractAction;
import com.nonage.controller.action.FindZipNumAction;
import com.nonage.controller.action.IdCheckFormAction;
import com.nonage.controller.action.IndexAction;
import com.nonage.controller.action.JoinAction;
import com.nonage.controller.action.JoinFormAction;
import com.nonage.controller.action.LoginAction;
import com.nonage.controller.action.LoginFormAction;
import com.nonage.controller.action.LogoutAction;
import com.nonage.controller.action.ProductDetailAction;
import com.nonage.controller.action.ProductKindAction;

public class ActionFactory {

//singleTone Pattern
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ActionFactory getInstance() {
		 return instance;
	}
	
// command 를 매개값으로 Action을 생성하는 메소드
	public Action getAction(String command) {
		Action action = null;
	    System.out.println("ActionFactory 요청을 받음을 확인 : " + command);
	    
	    if(command.equals("index")) {
	    	action = new IndexAction();
	    	
	    }else if(command.equals("product_detail")) {
	    	action = new ProductDetailAction();
	    	
	    }else if(command.equals("category")) {
	    	action = new ProductKindAction();
	    	
	    }else if(command.equals("contract")) {
	    	action = new ContractAction();
	    	
	    }else if(command.equals("join_form")) {
	    	action = new JoinFormAction();
	    	
	    }else if(command.equals("id_check_form")) {
	    	action = new IdCheckFormAction();
	    	
	    }else if(command.equals("find_zip_num")) {
	    	action = new FindZipNumAction();
	    	
	    }else if(command.equals("join")) {
	    	action = new JoinAction();
	    	
	    }else if(command.equals("login_form")) {
	    	action = new LoginFormAction();
	    	
	    }else if(command.equals("login")) {
	    	action = new LoginAction();
	    	
	    }else if(command.equals("logout")) {
	    	action = new LogoutAction();
	    	
	    }else if(command.equals("cart_insert")) {
	    	action = new CartInsertAction();
	    	
	    }else if(command.equals("cart_list")) {
			action = new CartListAction();
			
		}else if(command.equals("cart_delete")) {
			action = new CartDeleteAction();
			
		}
	    
	    return action;
	    
	    
	}
}
