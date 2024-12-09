package loop3;

public class Test02몸짱프로젝트 {
	public static void main(String[] args) {
		int dailyNum = 0, totalNum = 0;
		int oneday = 1;
		
		for(int day=1; day<=30; day++) {	
			System.out.println(day+"일차 개수 : "+oneday+"개");
			totalNum += oneday;
			oneday += 3;
		}
		System.out.println("30일간의 총 푸시업 개수 : " +totalNum+"개");
	}
}

