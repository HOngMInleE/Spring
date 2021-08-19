package com.springbook.ioc.injection;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
//		List<String> addressList = bean.getAddressList();
	// Set 출력
//		Set<String> addressList = bean.getAddressList();
//		for (String address : addressList) { //Set<String> 반환, String에 대입가능.
//			System.out.println(address.toString());
//		}
	// Map 출력
//		Map<String,String> addressList = bean.getAddressList();
//		for (String key : addressList.keySet()) { // keyset : key 전체정보를 가져옴.
//										//Set<String> 반환, String에 대입가능.
//			String value = (String) addressList.get(key); 
//			System.out.println("키 : " + key + " , 값 : " + value);
//			System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)));
//			}
	// Properties 출력
		Properties addressList = bean.getAddressList();
		
		for (String key : addressList.stringPropertyNames()) { // keyset과 같은 역할.
			String value = (String) addressList.get(key); 
			System.out.println("키 : " + key + " , 값 : " + value);
//			System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)));
		}

		
		
		
		
	}//main()
	
	
}
