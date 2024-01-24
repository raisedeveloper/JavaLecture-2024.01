package ch17_collection.part1_list.sec05_member;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {
	private static List<Member> list = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			int age = 20 + (int) (Math.random() * 20);
			list.add(new Member(age, "이름" + i, Math.random() > 0.5 ? "남" : "여"));
		}
		for (Member m : list)
			System.out.println(m);
		System.out.println("==============================================");

		// 나이가 30세 이상인 멤버 리스트
		List<Member> mList = getMemberListAbove30();
		mList.forEach(x -> System.out.println(x));		// 두 줄을 한 줄로 코딩하는 방법
		System.out.println("==============================================");
		
		// 여성 멤버 리스트
		mList = getMemberListByGender("여");
//		List<Member> gList = getMemberListByGender("여");  _ 이 방법도 사용가능
//		mList.forEach(x -> System.out.println(x));
		
		// 새로운 멤버 추가
		
			Member member = new Member(29, "순현", "남");
			inserMember(member);
			System.out.println(member);
			
			
			// 멤버 제거
			deleteMember("이름9");
			for (Member m: list)
				System.out.println(m);
			System.out.println("=============================");		// Main 에 들어가는 부분 끝
	}
																		// Static 부분 시작되는 부분
	
	static List<Member> getMemberListAbove30() { // getMemberListAbove30 임의 메소드 생성
		List<Member> mList = new ArrayList<>(); // mList = member list
		for (Member m : list) { // static 이라 this.list를 못씀
			if (m.getAge() >= 30)
				mList.add(m); // 30세 이상인 사람인 사람들만 m에 집어넣어라
		}
		return mList;
	}

	
	static List<Member> getMemberListByGender(String gender) {
		List<Member> mList = new ArrayList<>();
		for (Member m : list) {
			if (m.getGender().equals(gender)) {
				mList.add(m);
			}
		}
		return mList;
		
	}
	static void inserMember(Member member) {
		list.add(member);

	
	}
	
	static void deleteMember(String name) {
		Member member = null;
		for (Member m: list) {
			if (m.getName().equals(name)) {
				member = m;
				break;
			}
		}
		list.remove(member);
	}
	
	static void updateMember(Member member) {
		int index = list.indexOf(member);
		if (index >= 0)
			member.setAge(member.getAge() -1);
			list.set(index,  member);
	}
		
	}

