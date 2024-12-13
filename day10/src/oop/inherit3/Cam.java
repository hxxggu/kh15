package oop.inherit3;

public class Cam {
	private String name;
	private int pixel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	public void recored() {
		System.out.println("동영상 녹화 실행");
	}
}