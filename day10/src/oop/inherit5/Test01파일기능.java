package oop.inherit5;

public class Test01파일기능 {

	public static void main(String[] args) {
		Mp4File p1 = new Mp4File("동영상.mp4", 10);
		Mp3File p2 = new Mp3File("노래.mp3", 20);
		HwpFile s1 = new HwpFile("한글 파일.hwp", 10);
		PptFile s2 = new PptFile("강사 오리엔테이션.ppt", 20);
		
		p1.setSpeed(1);
		p1.execute();
		p1.forward();
		p1.rewind();
		p1.information();
				
		p2.setDuration(2);
		p2.execute();
		p2.forward();
		p2.rewind();
		p2.information();

		s1.setPagesize(20);
		s1.execute();
		s1.preview();
		s1.information();
		
		s2.setPagesize(30);
		s2.execute();
		s2.slideshow();
		s2.information();
	}
}
