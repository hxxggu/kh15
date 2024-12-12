package oop.modifier1;

public class Student {
	// 필드
	private String name;
	private int score;
	// setter 2개 + getter 2개 + init + show
	// 메서드 : 적극적으로 이용할 수 있도록 공개 (public : 모든 접근 허용)
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score<0 || score>100) return;
		this.score = score;
	}

	public void init(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	public void show() {
		System.out.println("이름 : " + this.getName());
		System.out.println("점수 : " + this.getScore());
	}
}
