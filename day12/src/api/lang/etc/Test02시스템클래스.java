package api.lang.etc;

public class Test02시스템클래스 {

	public static void main(String[] args) {
		//System 클래스
		//: Math처럼 생성이 불가하고 일회용 필드, 메서드만 존재하는 클래스
		//: 프로그램 외부의 시스템 정보를 이용할 수 있도록 도와주는 클래스
		
//		System a = new System();
		
		//시간 측정 (소요시간 측정용)
//		long time = System.currentTimeMillis();
//		System.out.println("time : "+time);
		
		//외부 환경 정보 (OS, JDK, ...) 읽기
//		System.out.println(System.getProperties()); //가능한 모든 정보를 출력
		System.out.println(System.getProperty("java.specification.version"));
		System.out.println(System.getProperty("os.name"));
		
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("windows")) { //윈도우라면
			System.out.println("윈도우에서 실행 중입니다.");
		} else if(os.toLowerCase().startsWith("mac")) { //mac os라면
			System.out.println("맥 OS에서 실행 중입니다.");
		}
		
		System.out.println(System.getProperty("user.country"));
		//어떤 국가용 OS를 사용하는지 (지역)
		System.out.println(System.getProperty("user.language"));
		//어떤 언어를 지정했는지 (언어)
		System.out.println(System.getProperty("user.name"));
		//user의 이름
		System.out.println(System.getProperty("os.version"));
		//윈도우 버전
		System.out.println(System.getProperty("os.arch"));
		//
		System.out.println(System.getProperty("user.home"));
		//해당 사용자가 아무런 제약 없이 사용할 수 있는 폴더
		System.out.println(System.getProperty("user.dir"));
		//현재 실행 중인 위치
		
		//오류 메시지 출력
		System.err.println("오류 메시지");
		
		//강제종료
		//return; //메서드 종료 명령
		System.exit(0); //프로그램 종료 명령(위치 무관)
		System.out.println("이 메시지는 안 보여요.");
	}
}
