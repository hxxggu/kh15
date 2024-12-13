package oop.inherit5;

public class Mp4File extends Play {
	private float speed;

	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		if(speed>=0.5f && speed<=2) { //float은 switch가 불가능함.
			this.speed = speed;			
		}
	}
	
	public Mp4File(String filename) {
		super(filename);
	}
	
	public Mp4File(String filename, float filesize, float speed) {
		super(filename);
		this.setSpeed(speed);
		this.speed = speed;
	}
	
	public Mp4File(String filename, long filesize) {
		super(filename, filesize);
	}
}
