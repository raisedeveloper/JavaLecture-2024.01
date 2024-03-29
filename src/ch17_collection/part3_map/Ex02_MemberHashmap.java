package ch17_collection.part3_map;

import java.util.HashMap;
import java.util.Map;

import ch17_collection.part2_sec12_Member.Member;



public class Ex02_MemberHashmap {
   public static void main(String[] args) {
      Map<Integer, Member> map = new HashMap<Integer, Member>();
      map.put(101, new Member(21, "james"));
      map.put(102, new Member(24, "maria"));
      map.put(103, new Member(21, "brian"));
      map.forEach((k, v) -> System.out.println(k + ": " + v));
      
      Map<Member, Integer> map2 = new HashMap<Member, Integer>();
      map2.put(new Member(21, "james"), 100000);
      map2.put(new Member(24, "maria"), 300000);
      map2.put(new Member(21, "brian"), 150000);
      map2.put(new Member(21, "james"), 100000); // 동일한 값이여도 또 들어감
      map2.forEach((k, v) -> System.out.println(k + ": " + v));

   }
}