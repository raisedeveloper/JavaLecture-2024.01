package ch17_collection.part2_sec12_Member;

import java.util.HashSet;
import java.util.Set;

public class MemberTreeSetMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();		// 같은 이름 2개 하나만 출력
		set.add(new Member(21, "james"));
		set.add(new Member(20, "maria"));
		set.add(new Member(21, "james"));
		
	System.out.println(set);

	}
}
