package oop.inherit3;

public class Camera {
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
	
	public void namePrint() {
		System.out.println("[" +this.name+ "]");
	}
	public void pixelPrint() {
		System.out.println(this.pixel+"만 화소");
	}
	public void record() {
		System.out.println("동영상 녹화");
	}

}