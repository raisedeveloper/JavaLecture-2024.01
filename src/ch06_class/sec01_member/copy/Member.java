package ch06_class.sec01_member.copy;

import java.time.LocalDate;

public class Member {
	// 필드, 멤버, 속성
	public String name;
	private LocalDate birthday;
	private String email;

	// 생성자(Constructor)
	public Member() {
	}

	public Member(String name, LocalDate birthday, String email) {
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}

	// 메소드(Method)
	public int getAge() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		int age = (month < birthday.getMonthValue() ||
					(month == birthday.getMonthValue() && day < birthday.getDayOfMonth())) ? 
					year - birthday.getYear() - 1 : year - birthday.getYear();
		return age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", birthday=" + birthday + ", email=" + email + 
			", age=" + getAge() + "]";
						
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 내부 클래스
	class InnerClass {
	}

}

class ExternalClass {

}