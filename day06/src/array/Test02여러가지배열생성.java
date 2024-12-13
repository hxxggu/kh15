package array;

public class Test02여러가지배열생성 {

	public static void main(String[] args) {
		
		//15.2, 20.6, 35.7, 22.1, 30.6
		double[] arr1 = new double[] {15.2, 20.6, 35.7, 22.1, 30.6};
		//arr1 -----> [?][?][?][?][?]
		for(int i=0; i<arr1.length; i++) {
			//arr1.length : arr1 배열의 처음부터 끝까지
			System.out.println(arr1[i]);
		}
		
		//자바, 안드로이드, 스프링, JSP
		String[] arr2 = new String[] {"자바", "안드로이드", "스프링", "JSP"};
		//arr2 -----> [?][?][?][?]
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		//100L, 200L, 300L
		long[] arr3 = new long[] {100L, 200L, 300L};
		//arr3 -----> [?][?][?]
		for(int i=0; i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}
}