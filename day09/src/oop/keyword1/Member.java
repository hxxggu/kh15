package oop.keyword1;

//회원 클래스
public class Member {
	private final String id;
	private String password;
	private String email;
	
	//setter의 존재가 수정을 위함이기 때문에 final은 setter가 불가능함
	//자동 setter, getter 생성 창에서 [ 빨간색 : private , 초록색 : public, f : final ]
	//final로 선언하는 경우, 처음 선언한 변수가 고정되므로 신중하게 할 것

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	
	//field가 final이면 모든 생성자에서 반드시 이 항목을 초기화해야 한다	
	public Member(String id, String password) {
		this(id, password, null);
	}
	public Member(String id, String password, String email) {
		this.id = id; //id에 들어가는 값이 생성자를 통해 첫 입력값을 final로 지정
		this.setPassword(password);
		this.setEmail(email);
	}
	
	
}
