package oop.inherit3;

public class Test01카메라기능 {

	public static void main(String[] args) {
		WebCam c1 = new WebCam();
		ActionCam c2 = new ActionCam();
		DigitalCam c3 = new DigitalCam();
		
		c1.setName("웹캠(WebCam)");
		c1.namePrint();
		c1.setPixel(400);
		c1.pixelPrint();
		c1.record();
		c1.decorate();
		
		c2.setName("액션캠(ActionCam)");
		c2.namePrint();
		c2.setPixel(2700);
		c2.pixelPrint();
		c2.record();
		c2.slowMotion();
		c2.reduce();
		
		c3.setName("디지털카메라(Digital Camera)");
		c3.namePrint();
		c3.setPixel(1200);
		c3.pixelPrint();
		c3.record();
		c3.wideRecord();
		c3.slowMotiomn();
	}

}
