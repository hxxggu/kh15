package oop.constructor3;

public class Lecture {
	//field 접근 제한
	private String title;
	private String category;
	private int hour;
	private int price;
	private String type;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour <= 0) return;
		this.hour = hour;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		switch(type) {
		case "온라인","오프라인","혼합":
		this.type = type;
		}
	}
	public int getPricePerHour() {
		return this.price/this.hour;
	}
	
	public void show() {
		System.out.println("<강좌 정보>");
		System.out.println("강좌명 : "+this.getTitle());
		System.out.println("구분 : "+this.getCategory());
		System.out.print("수강료 : "+this.getPrice()+"원");
		System.out.println(" (시간 당 : "+this.getPricePerHour()+"원)");
		System.out.println("수업형태 : "+this.getType());
	}
	
	public Lecture(String title, String category, int hour, int price) {
		this(title, category, hour, price, "오프라인");
	}
	public Lecture(String title, String category, int hour, int price, String type) {
		this.setTitle(title);
		this.setCategory(category);
		this.setHour(hour);
		this.setPrice(price);
		this.setType(type);	
	}
	
	
}
