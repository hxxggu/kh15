package oop.inherit5;

public class Play extends SameFunc {
	
	//생성자를 상위 클래스에 맞춰서 만든다
	public Play(String filename) {
		super(filename);
	}
	
	public Play(String filename, long filesize) {
		super(filename, filesize);
	}

	public void forward() {
		System.out.println("빨리감기");
	}
	
	public void rewind() {
		System.out.println("되감기");
	}
}
