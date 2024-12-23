package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, String> userList = new HashMap<>();
		
		userList.put("khadmin", "admin1234");
		userList.put("khstudent", "student1234");
		userList.put("khteacher", "teacher1234");
		userList.put("khmanager", "manager1234");
				
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			try {
				if(userList.containsKey(id) && (userList.get(id)).equals(pw)) {
					System.out.println("** 로그인 성공 **");
			} else {
				throw new Exception("** 입력하신 정보가 일치하지 않습니다 **");
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
