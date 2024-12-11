package oop.basic2;

public class Test01인스턴스생성문제 {
	
	public static void main(String[] args) {
		Info sub = new Info();
		Info korea = new Info();
		Info japan = new Info();
		Info china = new Info();
		Info us = new Info();
		
		sub.nation = "이름";
		sub.capital = "수도";
		sub.poluation = "인구";
		
		korea.nation = "한국";
		korea.capital = "서울";
		korea.poluation = "5천만";
		
		japan.nation = "일본";
		japan.capital = "도쿄";
		japan.poluation = "1억2천만";
		
		china.nation = "중국";
		china.capital = "베이징";
		china.poluation = "14억";
		
		us.nation = "미국";
		us.capital = "워싱턴";
		us.poluation = "2억5천만";
		
		String[][] table = new String[][] { //4(+1)나라의 3정보
			{sub.nation, sub.capital, sub.poluation},
			{korea.nation, korea.capital, korea.poluation},
			{japan.nation, japan.capital, japan.poluation},
			{china.nation, china.capital, china.poluation},
			{us.nation, us.capital, us.poluation},
		};

		for(int i=0; i<5; i++) {
			System.out.println();
			for(int j=0; j<3; j++) {
				System.out.print(table[i][j]+" ");
			}
		}
	}
}
