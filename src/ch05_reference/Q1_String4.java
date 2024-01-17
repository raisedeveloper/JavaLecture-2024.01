package ch05_reference;

public class Q1_String4 {
	// 어떤 걸 기준으로 나누면 배열을 어레이로 나누는데
	// 배열의 0번째부터 시작하는 자릿수의 위치 개념을 알아야 함
	public static void main(String[] args) {

		folder();

	}

	static void folder() {
		String text = "C:\\workspace\\frontEndLecture-2024.01\\03.javascript\\ch07.표준내장객체\\04.String연습.js";
		String array[] = text.split("\\\\");
		System.out.println(array[array.length - 1]);

	}

}
