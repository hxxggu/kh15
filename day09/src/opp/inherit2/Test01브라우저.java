package opp.inherit2;

public class Test01브라우저 {

	public static void main(String[] args) {
		
		Chrome b1 = new Chrome();
		b1.setUrl("http://www.google.com");
		b1.refresh();
		b1.move();
		b1.develop();
		b1.chromeStore();		
		
		Edge b2 = new Edge();
		b2.setUrl("http://www.microsoft.com");
		b2.refresh();
		b2.move();
		b2.fullScreen();
		
		Whale b3 = new Whale();
		b3.setUrl("http://www.naver.com");
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
	}
}