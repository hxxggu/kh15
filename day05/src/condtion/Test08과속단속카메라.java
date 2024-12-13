package condtion;

public class Test08과속단속카메라 {

	public static void main(String[] args) {
		//입력
		int speed = 105; //자동차의 속도
		
		//처리
		int limit = 100; //제한속도
		//int over = 110;
		int per = 10; //여유
		int over = limit+limit*per/100;
		//System.out.println("over = "+over);
		
		if(speed >= over) {
			//System.out.println("과속");
			int gap = over-speed;
			//int fine = 4만원+10km 당 1만원;
			int fine = 40000+gap/10*10000;
			System.out.println("초과한 속도 : "+gap+"km");
			if(fine<10000) {
			System.out.println("범칙금 : "+fine+"원");
			} else {
			System.out.println("범칙금 : 100000원");
			}
		}
		else { 
			System.out.println("정상 통과");
		}
	}
}
