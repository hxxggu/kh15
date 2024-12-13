package oop.inherit5;

public class HwpFile extends Page {
	
	public HwpFile(String filename, int pagesize) {
		super(filename, pagesize);
	}
	
	public void preview() {
		System.out.println("미리보기");
	}
}
