package ch05_reference;

public class Person_Ex11연결 {
	private String name;
	private int age; 
	private String job;
	public Person_Ex11연결() { }
	public Person_Ex11연결(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	
	public String getName() {
		return name;
	}
}
