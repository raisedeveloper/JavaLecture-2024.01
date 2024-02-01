package Test;

public class javaTest2 {

   public static void main(String[] args) {
      int sum = 0;
      int s = 20;
      
      for (int i=1; i <= s; i = i+2) {
         sum += i*i;
      }
      System.out.println("1에서 20까지 홀수 제곱의 합 = " + sum);
      
      int sumOfPrimeNumber = 0;
      for (int i = 2; i <= 100; i++) {
    	  if (isPrime(i))
    		  sumOfPrimeNumber += i;
      }
      System.out.println("2에서 100까지 소수의 합 = " + sumOfPrimeNumber);
   }
   static boolean isPrime(int num) {
	   for (int i = 2; i <= num -1; i++) {
		   if (num % i == 0)
			   return false;
	   }
	   	return true;
   }
}
