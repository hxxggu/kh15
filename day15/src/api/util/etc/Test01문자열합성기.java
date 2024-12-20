package api.util.etc;

import java.util.StringJoiner;

public class Test01문자열합성기 {
	public static void main(String[] args) {
		
		String a = "바나나";
		String b = "딸기";
		String c = "포도";
		
		System.out.println("[" + a + "," + b + "," + c + "]");
		System.out.println("[" + String.join(",", a, b, c)+"]");
		
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		joiner.add(a);
		joiner.add(b);
		joiner.add(c);
		System.out.println(joiner.toString());
		
	}
}