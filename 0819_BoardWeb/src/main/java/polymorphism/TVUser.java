package polymorphism;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// xml 파일 생성
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (SamsungTV) factory.getBean("tv");// xml의 id값 가져옴
				// Bean의 class 값이 SamsungTv이기때문에 Lg는 오류발생. TV는 가능(부모)
//		TV tv2 = (TV) factory.getBean("tv");
//		TV tv3 = (TV) factory.getBean("tv");
//		TV tv4 = (TV) factory.getBean("tv");
		// 생성자는 한 번만 생성 (SingleTone Pattern)
			// Bean의 scope="prototype" 설정시 4번 생성됨.
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close(); // Bean 닫아주기
		
		
		
	// 표준화, 다형성
		
//		BeanFactory factory = new BeanFactory();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("tv브랜드를 입력하세요.");
//		String kind = sc.nextLine();
//		sc.close();
//		
//		TV tv = (TV) factory.getBean(kind);
		
		
//		TV tv = new SamsungTV();
//		tv = new LgTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		
		
		
		
	}//main()

	
	
	
	
}
