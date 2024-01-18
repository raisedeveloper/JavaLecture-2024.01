package ch05_reference;

import java.util.Arrays;

public class Q1_String1 {

	// 1. 1에서 1000 사이에 0은 몇번, 1은 몇번, ... 9는 몇번 사용되었는가?
	// tip - 123456789..9991000
	public static void main(String[] args) {
		String times = "";
		for (int i = 1; i <= 1000; i++) {
			times += i;

			// 정규표현식 사용
			// [^3] : 3이 아닌 글자
		}

		for (int i = 0; i <= 9; i++) {
			String regExp = "[^" + i + "]";
			int count = times.replaceAll(regExp, "").length(); // count 는 'times'의 'length'를 찾는 용도임
			System.out.println(i + ": " + count);
		}

		// 배열을 사용해서 숫자를 일일이 카운트 하는 방법
		int[] countArray = new int[10]; // 또 다른 방법 : {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		for (int i = 0; i < times.length(); i++) {
			char num = times.charAt(i); // '1', '2', ... '0' 중에 하나의 값
			int numValue = num - '0'; // 1, 2, ..., 0 숫자 값
			countArray[numValue]++;
		}
		System.out.println(Arrays.toString(countArray));
	}
}