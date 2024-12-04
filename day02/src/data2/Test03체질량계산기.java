package data2;

public class Test03체질량계산기 {

	public static void main(String[] args) {
		int height = 180;
		float changeMeter = height/100f;
		int weight = 80;
		
		float bmi = weight/(changeMeter*changeMeter);
		
		System.out.print("BMI : "+bmi);
	}
}
