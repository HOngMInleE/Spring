package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//Spring Container에 빈으로 등록하는 이노테이션들

//@Service		
//@Repository
//@Controller

@Component("tv") // component가 붙은 대상 중 id가 ("tv")인 채로  / 스프링컨테이너에 빈으로 등록.
public class LgTV implements TV{

//	@Autowired // 자동 (의존) 주입	//타입으로 구분  /apple, sony 두개의 speaker 타입이 존재해 오류 발생
//	@Qualifier("apple") // 한정자
//	@Resource(name="sony") // 한정, 의존 주입
	
	@Autowired // 한 개의 타입만 사용한다면 오류 발생없음.
	private Speaker speaker; 
	
	@Override
	public void powerOn() {
		System.out.println("LgTV---전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
//		System.out.println("LgTV---소리를 키운다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("LgTV---소리를 줄인다.");
		speaker.volumeDown();
	}
	
}
