package oop.inherit5;

public class Page extends SameFunc {
	private int pagesize; //절대규칙(0보다는 커야함)
	//protected

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public Page(String filename, int pagesize) {
		super(filename);
		this.pagesize = pagesize;
	}
}
