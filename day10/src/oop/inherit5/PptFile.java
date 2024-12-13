package oop.inherit5;

public class PptFile extends Page {

	public PptFile(String filename, int pagesize) {
		super(filename, pagesize);
	}
	public void slideshow() {
		System.out.println("슬라이드쇼");
	}
}
