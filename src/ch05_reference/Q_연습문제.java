package ch05_reference;

public class Q_연습문제 {

	public static void main(String[] args) {
		// 연습문제
		// 1. 1에서 1000사이에 0은 몇번, 1은 몇번, ..., 9는 몇번 사용되었는가?
		System.out.println("1번 문제");
		int count = 0;
		String numStr = "";
		for (int i = 1; i <= 1000; i++)
			numStr += Integer.toString(i);

		for (int i = 0; i <= 9; i++) {
			count = numStr.length() - numStr.replace(Integer.toString(i), "").length();
			System.out.print(i + ": " + count + "   ");
		}
		System.out.println("\n"); 

		// 2. 디지털 시계, 00:00 ~ 23:59
		// 하루동안 3이 표시되는 시간은 몇초인가?
		System.out.println("2번 문제");
		int displayTime = 0;
		for (int hour = 0; hour <= 23; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				String clock = hour + ":" + minute;
				if (clock.indexOf("3") >= 0)
					displayTime += 60;
			}
		}
		System.out.println("하루동안 3이 표시되는 시간은 " + displayTime + "초 입니다. \n");

		// 3. 두개의 세자리수를 곱해서 나온 결과가 palindrome일때
		// 가장 큰 palindrome 수와 어떤 수를 곱해서 나온 결과인가?
		System.out.println("3번 문제");
		int maxPal = 0, max1 = 0, max2 = 0;
		for (int i = 100; i <= 999; i++) {
			for (int k = i; k <= 999; k++) {
				String mul1 = Integer.toString(i * k);
				if (isPalindrome(mul1)) {
					int mul2 = Integer.parseInt(mul1);
					if (mul2 > maxPal) {
						maxPal = mul2;
						max1 = i;
						max2 = k;
					}
				}
			}
		}
		System.out.println(max1 + " x " + max2 + " = " + maxPal + "\n"); // 913 x 993 = 906609

		// 4. C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js
		// 에서 파일명(04.String연습.js)만 출력하세요.
		System.out.println("4번 문제");
		String path = "C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js";
		String[] pathes = path.split("/");
		System.out.println(pathes[pathes.length - 1] + "\n");

	}

	static boolean isPalindrome(String s) {
		String[] a = s.split("");
		String b = "";
		int leng = s.length() - 1;
		for (int i = leng; i >= 0; i--) {
			b += a[i];
		}
		int k = Integer.parseInt(s);
		int l = Integer.parseInt(b);
		return k == l;
	}

}