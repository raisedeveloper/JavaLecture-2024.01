package ch10_oop.sec02_constructor;

public class Worker extends Person {
   public Worker(String name, int age) {
      super(name, age);
   }

   int workerId;
   
   public void work() {
      System.out.println(name + "이/가 열심히 일을 합니다.");
   }
}