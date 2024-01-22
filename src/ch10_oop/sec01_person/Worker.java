package ch10_oop.sec01_person;

public class Worker extends Person{		// Person 상속 받음 - Worker 가 자식
	int workerId;
	
	void work() {
		System.out.println(name + " 이/가 열심히 일을 합니다.");	
	}
}
