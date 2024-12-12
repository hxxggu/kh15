package oop.inner1;


//경찰이 총을 2자루(left, right) 소유할 수 있도록 구현
public class Police {
	private Gun left = new Gun(); //이 상태로는 값을 입력할 수 없음 / Gun이 들어갈 수 있는 자리를 만든 것
	private Gun right = new Gun();

	//중첩 클래스(nested class)
	//: 클래스 간의 소유 관계를 구현할 수 있다
	//: 클래스도 멤버 취급되므로 접근 제한 가능
	public class Gun {
		
	}
}