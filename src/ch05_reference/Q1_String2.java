package ch05_reference;

public class Q1_String2 {

	// 2. 디지털 시계, 00:00 ~ 23:59
	// 하루동안 3이 표시되는 시간은 몇초인가? 답: 29700

	public static void main(String[] args) {
//		System.out.println("2번 문제");
		int time = 0;
		for (int hour = 0; hour <= 23; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				String clock = hour + ":" + minute;
				if (clock.indexOf("3") >= 0) {
//					System.out.println(clock + " = " + clock.indexOf("3"));
					time += 60;
				}
			}
		}
		System.out.println("하루동안 3이 표시되는 시간: " + time + "초 \n");
	}
}