package ch10_oop.sec01_person;

public class Main {

   public static void main(String[] args) {
      // Person 객체
      Person person = new Person();
      person.name = "제임스";
      person.age = 27;
      person.eat();
      person.sleep();

      // Student 객체
      Student student = new Student();
      student.name = "마리아"; // 부모 필드
      student.age = 23;       // 부모 필드
      student.studentId = 1234; // 부모 메소드
      student.eat();
      student.sleep();
      student.study();

      // Worker 객체
      Worker worker = new Worker();
      worker.name = "브라이언";   // 부모 필드
      worker.age = 32;       // 부모 필드
      worker.workerId = 1234;// 부모 메소드
      worker.eat();
      worker.sleep();
      worker.work();

      // 설명 : 동물의 특징을 엮으면 포유류, 조류, 파충류 등 나뉘고 결국 동물이라는 카테고리에서 시작하게 됨
      //		부모 자식 간의 상속받는 유전인자가 있다는 것과 'Class'가 비슷하다			
      
      
   }

}