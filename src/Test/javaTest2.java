package Test;

public class javaTest2 {

   public static void main(String[] args) {
      int sum = 0;
      int s = 20;
      
      for (int i=1; i <= s; i = i+2) {
         sum += i*i;
      }
      System.out.println(sum);
   }

}
