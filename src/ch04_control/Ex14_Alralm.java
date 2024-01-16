package ch04_control;

import java.util.Scanner;
public class Ex14_Alralm {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("실제 기상 시간: ");
		String inputStr = scan.nextLine();
		String inputStr2 = scan.nextLine();
		
		int hour = Integer.parseInt(inputStr);
		int minute = Integer.parseInt(inputStr2);
		int newHour = 0, newMin = 0;

		if (minute >= 45) {
		    newHour = hour;
		    newMin = minute - 45;
		} else {
		    if (hour == 0) {
		        newHour = 23;
		        newMin = minute + 60 - 45;
		    } else {
		        newHour = hour - 1;
		        newMin = minute + 60 - 45;
		    }
		}
		System.out.println("알람을 45분 이전 시각으로 맞추기 :");		
		System.out.println(newHour + "시" + newMin + "분" );
	}
}
