package oop.inherit5;

public class Mp3File extends Play {
	private int duration;
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		if(duration < 0) return;
		this.duration = duration;
	}
	public Mp3File(String filename) {
		super(filename);
	}
	
	public Mp3File(String filename, long filesize) {
		super(filename, filesize);
	}
}