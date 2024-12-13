package oop.inherit3;

public class Test01카메라정보 {

	public static void main(String[] args) {
		
		WebCam a = new WebCam();
		a.recored();
		a.decorate();
		
		ActionCam b = new ActionCam();
		b.recored();
		b.slowCam();
		b.reduce();
		
		DigitalCam c = new DigitalCam();
		c.recored();
		c.wideRecord();
		c.slowCam();
	}
}
