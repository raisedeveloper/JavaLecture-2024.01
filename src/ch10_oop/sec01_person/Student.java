package ch10_oop.sec01_person;

public class Student extends Person {		// Student 의 부모는 'Person'임 - 부모 지정하면 부모의 메소드 사용 가능함
	int studentId;
		
	public void study() {
		System.out.println(name + " 이/가 공부를 합니다.");
		
	}
}
