package oop.constructor3;

public class Subject {
	
	private String name;
	private String section;
	private int time;
	private int money;
	private String temp;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		if(time%30 != 0) return;
		this.time = time;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money<0 && money%1000!=0) return;
		this.money = money;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		switch(temp) {
		case "온라인", "오프라인", "혼합":
		this.temp = temp;
		};
	}
	
	public Subject(String name, String section, int time, int money) {
		this(name, section, time, money, "");
	}
	
	public Subject(String name, String section, int time, int money, String temp) {
		this.setName(name);
		this.setSection(section);
		this.setTime(time);
		this.setMoney(money);
		this.setTemp(temp);
	}
	
	public void show() {
		System.out.println("< 강좌 소개 >");
		System.out.println("강좌명 : "+this.getName());
		System.out.println("구분 : "+this.getSection());
		System.out.println("강의 시간 : "+this.getTime());
		System.out.println("수강료 : "+this.getMoney());
		if(temp == "") {
			System.out.println("수업형태 : 오프라인");
		} else {
			System.out.println("수업형태 : "+this.getTemp());
		}
	}
}
