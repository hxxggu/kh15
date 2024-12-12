package oop.constructor2;

public class Player {
	//field
	private String id;
	private String job;
	private int level;
	private int gold;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		switch(job) {
		case "전사", "성직자","도둑" :
		this.job = job;
		};
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level < 1) return;
		this.level = level;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		if(gold < 0) return;
		this.gold = gold;
	}
	//public을 쓰는 이유 : 다른 패키지에서도 해당 메서드를 사용할 수 있게 하기 위함
	public void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : "+this.getId());
		System.out.println("직업 : "+this.getJob());
		System.out.println("레벨 : "+this.getLevel());
		System.out.println("소지골드 : "+this.getGold());
	}
	
	//init 메서드 대신 생성자
	public Player(String id, String job) {
		this(id, job, 1, 0); //생성자 몰아주기 (하단의 메서드를 호출해서 사용)
//		this.setId(id);
//		this.setJob(job);
//		this.setLevel(1);
//		this.setGold(0);
	}
	
	public Player(String id, String job, int level, int gold) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setGold(gold);
	}
	
	
	
	
	
	
	
	
	
}
