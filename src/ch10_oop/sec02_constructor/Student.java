package ch10_oop.sec02_constructor;

public class Student extends Person{
   int studentId;
   
   public Student(String name, int age, int studentId) {
      super(name, age);// 생성자는 상속이 되지 않기 때문에 선언을 해주어야 함. 부모의 생성자 호출
      this.studentId = studentId; 
   }

   public void study() {
      System.out.println(name + "이/가 공부를 합니다.");
   }
   
   
}