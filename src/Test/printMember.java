package Test;

import java.util.ArrayList;
public class printMember {

	public static void main(String[] args) {
//		System.out.println(getMemberList());
		ArrayList<Member> members = getMemberList();
//		for (Member member : members) {
//			member.setTel("010-0000-0000");
//		}
		for (int i = 0; i < members.size(); i++) {
			members.get(i).setTel("000-0000-0000");
			System.out.println(members.get(i));
		}
	}
	public static ArrayList<Member> getMemberList() {

		ArrayList<Member> memberList = new ArrayList<>();

		Member james = new Member(1, "james", 1990, "010-1234-5678");
		memberList.add(james);
		Member maria = new Member(2, "maria", 1985, "010-8765-4321");
		memberList.add(maria);
		return memberList;
	}
}