package Test;

public class javaTest {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		
		for (i=1; i <= 100; i++) {
			if (i % 3 == 0)
			sum += i; }
			System.out.print("1에서 100까지 3의 배수의 합 = " + sum);
	}

}
