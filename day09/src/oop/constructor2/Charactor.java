package oop.constructor2;

public class Charactor {
	
	private String id;
	private String job;
	private int level;
	private int money;
	
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
		case "도둑":
		case "성직자":
		case "전사":
		this.job = job;
		};
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(0 > level) return;
		this.level = level;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(-1 > money) return;
		this.money = money;
	}
	
	public Charactor(String id, String job) {
		this.setId(id);
		this.setJob(job);
	}
	
	public Charactor(String id, String job, int level, int money) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setMoney(money);
	}
	
	public void show() {
		if(level==0 && money==0) {
			System.out.println("아이디 : " +this.getId());
			System.out.println("직업 : " +this.getJob());
			System.out.println("레벨 : 1");
			System.out.println("소지금 : 0\n");
		} else {
			System.out.println("아이디 : " +this.getId());
			System.out.println("직업 : " +this.getJob());
			System.out.println("레벨 : " +this.getLevel());
			System.out.println("소지금 : " +this.getMoney()+"\n");
		}
		
	}

}
