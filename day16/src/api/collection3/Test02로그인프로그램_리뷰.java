package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램_리뷰 {
	public static void main(String[] args) {
		//데이터 준비
		Map<String, String> db = new HashMap<>();
		db.put("khadmin", "admin1234");
		db.put("khstudent", "student1234");
		db.put("khteacher", "teacher1234");
		db.put("khmanager", "manager1234");
		
		//사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		sc.close();

//		if(db.containsKey(id) && db.containsValue(password)) { //로그인 성공시
		if(db.containsKey(id) && db.get(id).equals(password)) {
			System.out.println("로그인 성공");
			
		} else { //로그인 실패시
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
	}
}
