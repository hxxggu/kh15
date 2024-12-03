package data2;

public class Test03체질량계산기 {

	public static void main(String[] args) {
		int height = 180;
		double changeMeter = 180*0.01;
		int weight = 80;
		
		double bmi = weight/(changeMeter*changeMeter);
		
		System.out.print("BMI : "+bmi);
	}
}
