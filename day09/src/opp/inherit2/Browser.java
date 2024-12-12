package opp.inherit2;

//공통 내용에 대한 클래스(수퍼클래스, 상위클래스, 부모 클래스)
public class Browser {
		//공통 필드
		private String url;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		//공통 메서드
		public void refresh() {
			System.out.println("새로고침 기능 실행");
		}
		public void move() {
			System.out.println("페이지 이동 기능 실행");
		}
}