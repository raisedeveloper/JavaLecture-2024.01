//package ch04_control;
//
//public class Q3_연습문제3 {
//
//   public static void main(String[] args) {
//      for (int i = 0;; i++) {
//            System.out.println(i * 2);
//         if (i == 5) {
//            break;
//         }
//      }
//   }
//
//}
//
//package ch04_control;
//
//public class Q3_연습문제3 {
//
//   public static void main(String[] args) {
//      String result = "";
//      for (int i = 0;; i++) {
//         if (i < 5)
//            result += i * 2 + ", ";
//         if (i == 5) {
//            result += i * 2 ;
//            break;
//         }
//      }
//      System.out.println(result);
//   }
//
//}

package ch04_control;

public class Q3_for문코드완성 {

	public static void main(String[] args) {
		for (int i = 0; ; i++) {
			if (i > 10) {
				break;
			}
			if (i % 2 == 1) {
				if (i == 11)
					break;
				continue;
			}
			System.out.println(i);
		}
	}

}