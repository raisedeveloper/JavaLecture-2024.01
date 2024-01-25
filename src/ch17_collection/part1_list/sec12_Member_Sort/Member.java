package ch17_collection.part1_list.sec12_Member_Sort;

public class Member implements Comparable {
   private int age;
   private String name;

   public Member(int age, String name) {
      this.age = age;
      this.name = name;
   }
   
   // List에서 정렬을 
   // TreeSet. TreeMap에서 사용되는 객체는 Comparable I/F를 구현해야 함.
   // 0와 크고 작은 것만 조정할 수 있으므로 같은 값일 경우 0이라고 해석함.
   @Override
   public int compareTo(Object obj) {
      if (obj instanceof Member) {
         Member m = (Member) obj;
         // 이름으로 먼저 비교하고, 같으면 나이의 역순으로 출력
         if (this.name.compareTo(m.getName()) == 0)
            return m.getAge() - this.age;
         else// 이름으로 비교
            return this.name.compareTo(m.getName());
      } else
         return 0;
   }

   public Member() {
   }

   @Override
   public String toString() {
      return "Member [age=" + age + ", name=" + name + "]";
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}