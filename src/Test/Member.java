package Test;

import java.time.LocalDate;

public class Member {

	private int memberId;
	private String memberName;
	private int birthYear;
	private String tel;
	
	public Member( ) { }
	public Member(int memberId, String memberName, int birthYear, String tel) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.birthYear = birthYear;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Id = " + memberId + ", 이름 = " + memberName + ", 나이 = " + birthYear + ", 전화번호 = "
				+ tel + "";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private int getAge() {
		LocalDate today = LocalDate.now();
		return today.getYear() - birthYear;
	}
}