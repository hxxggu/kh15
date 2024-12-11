package oop.method5;

public class Student {
	String name;
	int kor, eng, math;
	
	//setter 메서드
	// : 필드 한 개를 변경할 수 있는 메서드(+조건으로 필터링 가능)
	// : 이름은 set+필드명 으로 작성
	// > 조건에 맞지 않는 입력값이 들어오는 것을 방지
	
	//getter 메서드
	// : 필드 한 개를 반환할 수 있는 메서드(+가상의 메서드 생성 가능)
	// : 이름은 get+필드명 으로 작성
	// > 긴 수식 없이 호출만으로 계산이 가능하게 하고, 출력하는 부분을 깔끔하게 할 수 만듦.
	
	void setName(String name) {
		this.name = name;
	}
	
//	void setKor(int kor) { //차단하는 조건이 많을수록 가로로 늘어남.
//		if(kor>=0 && kor<=100) {
//			this.kor = kor;			
//		}
//	} //if 70점 입력 > 조건에 맞으니 입력됨, but 120점을 입력 > 조건에 맞지 않으므로 입력되지 않음  
	
	void setKor(int kor) { //차단하는 조건이 많을수록 이쪽이 좋음. 조건이 붙을수록 if문을 덧붙여 세로로 길어짐.
		if(kor<0 || kor>100) {
			return; //메서드 중지 명령
		}
		this.kor = kor;
	} //상단 주석처리한 부분과 이 부분은 결과값이 동일. 사용자가 선택해서 사용.
	
	void setEng(int eng) {
		if(eng<0 || eng>100) {
			return;
		}
		this.eng = eng;
	}
	
	void setMath(int math) {
		if(math<0 || math>100){
			return;
		}
		this.math = math;
	}
	
	//반환할 데이터가 있는 경우에는 반환자료형을 void가 아니라 다른 형태로 변경
	//void는 반환할 데이터가 없다는 의미의 표시이다
	String getName() {
		return this.name; //주인공의 필드 name을 외부에서 가져가도록 반환
	}
	int getKor() {
		return this.kor;
	}
	int getEng() {
		return this.eng;
	}
	int getMath() {
		return this.math;
	}
	int getTotal() {
		return this.getKor()+this.getEng()+this.getMath();
	}
	float getAvg() {
		return this.getTotal()/3f;
	}
	
	void init(String name, int kor, int eng, int math) {
		this.setName(name);
		this.setKor(kor);
		this.setEng(eng);
		this.setMath(math);
	}
	
	void show() {
		System.out.println("이름 : "+this.getName()); //메서드를 호출할 때는 무조건 끝에 괄호가 들어감
		System.out.println("국어 : "+this.getKor());
		System.out.println("영어 : "+this.getEng());
		System.out.println("수학 : "+this.getMath());
		System.out.println("총점 : "+this.getTotal());
		System.out.println("평균 : "+this.getAvg());
	} //getter 메서드를 사용 시 출력이 깔끔해짐.
}