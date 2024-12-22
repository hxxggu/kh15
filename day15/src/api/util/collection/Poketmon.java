package api.util.collection;

import java.util.Objects;

public class Poketmon {
	private int num;
	private String name, attr;
	
	public Poketmon(int num, String name, String attr) {
		this.num = num;
		this.name = name;
		this.attr = attr;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAttr() {
		return attr;
	}
	
	public int hashCode() {
		return Objects.hash(num, name, attr);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Poketmon other = (Poketmon) obj;
		return Objects.equals(num, other.num) && Objects.equals(name, other.name) && Objects.equals(attr, other.attr);
	}
	
	public String toString() {
		return "번호 : " + num + ", 이름 : " + name + ", 속성 : " + attr;
	}
}