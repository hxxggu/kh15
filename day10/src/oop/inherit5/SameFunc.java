package oop.inherit5;

public class SameFunc {
	private String filename; //향후 변경될 가능성이 농후
	private long filesize; //절대불변의 규칙
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize < 0) {
			this.filesize = filesize;
		}
	}
	
	//생성자 - 파일 이름(필수), 파일 크기(선택)
	public SameFunc(String filename) {
		this(filename, 0L);
	}	
	public SameFunc(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	
	public void execute() {
		System.out.println("실행");
	}
	
	public final void information() {
		System.out.println("[ 파일 정보 ]");
		System.out.println("파일명 : " + this.filename);
		System.out.println("파일 크기 : " + this.filesize + "bytes");
	}
}
