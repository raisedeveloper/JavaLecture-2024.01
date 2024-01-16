package ch04_control;

import java.util.Scanner;

public class Ex15_PerfectNumber {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("완전수의 범위>  ");
      int num = Integer.parseInt(scan.nextLine());
      divSum(num);
      scan.close();
   }

   static void divSum(int num) {
      for (int i = 1; i < num; i++) {
         int sum = 0;
         for (int k = 1; k < i; k++) {
            if (i % k == 0) {
               sum += k;
            }
         }
         if (sum == i)
            System.out.println("완전수 : " + i);
         sum = 0;
      }
   }
}