package ch10_oop.sec03_override;

public class Main {

   public static void main(String[] args) {
      // Person 객체
      Parent parent = new Parent();
      parent.parentField = 1000;
      parent.parentMethod();

      // Student 객체
      Child child = new Child();
      child.childField = 300;
      child.parentField = 600;
      child.childMethod();
      child.parentMethod();
      
//      Parent p = new Child();			// '폴리모피즘' 타입
//      Child c = (Child)new Parent();  	// 강제 변환 타입


   }

}