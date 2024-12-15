package oop.multi2;

public abstract class Transportation {
	protected int num;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		if(1<=num && num<=5) this.num = num;
	}

	public Transportation(int num) {
		this.num = num;
	}
	
	public abstract void move();
}