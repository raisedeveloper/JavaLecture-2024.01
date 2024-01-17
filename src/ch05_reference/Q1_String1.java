package ch05_reference;

import java.util.Scanner;

public class Q1_String1 {

	// 1. 1에서 1000 사이에 0은 몇번, 1은 몇번, ... 9는 몇번 사용되었는가?
	// tip - 123456789..9991000
	public static void main(String[] args) {
		String times = "";
		int sum1 = 0;
		for (int i = 1; i <= 1000; i++) {
			times += i;
		}
		for (int i = 0; i <= 9; i++) {
			String regExp = "[^" + i + "]";
			int count = times.replaceAll(regExp, "").length();
			System.out.println(i + ": " + count);
		}

	}

}