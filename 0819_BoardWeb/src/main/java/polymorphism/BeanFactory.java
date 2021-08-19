package polymorphism;

public class BeanFactory {
	// 객체 생성 클래스
	
	public Object getBean(String beanName) {
		
		// 요청에 맞게 객체 생성
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		}else if (beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}// getBean()
	
}
