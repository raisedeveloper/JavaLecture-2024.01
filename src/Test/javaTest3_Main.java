package Test;

public class javaTest3_Main {

	public static void main(String[] args) {
		int sum = 0;

		for (int num = 2; num <= 100; num++) {
			if (isPrime(num)) {
				sum += num;
			}
		}
		System.out.println(sum);
	}
	public static boolean isPrime(int num) {
		if(num < 2)
			return false;
		for(int i = 2; i < num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
}
