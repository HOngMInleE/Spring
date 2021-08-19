package polymorphism;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성 성공");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker---소리를 키운다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker---소리를 줄인다.");
	}
	
	
}
