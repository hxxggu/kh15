package data3;

public class Test04논리연산 {
	public static void main(String[] args) {
		//Ex. 청소년 판정 (=중고등학생, 14-19세)
		
		int age=7;
		// and(&&)
		//boolean teen=age가 14-19 사이인가요?
		//boolean teen=14<=age<=19;
		boolean teen=(14<=age)&&(age<=19);
		System.out.println(teen);
		
		// or(||)
		//Ex. 무임승차대상인가요? (65세 이상 or 8세 미만)
		//boolean free=age가 65세 이상 또는 8세 미만인가요?
		boolean free=(65<=age)||(age<8);
		System.out.println(free);
		
		// not(!)
		//boolean free2=age가 8세 이상 65세 미만이 아닌가요?
		boolean free2=!((age>=8)&&(age<65));
		System.out.println(free2);
		//not(!)은 우측의 내용을 반대로 해석
	}
}
