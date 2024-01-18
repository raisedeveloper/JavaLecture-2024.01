package ch05_reference;

public class Q1_String3 {

	// 3. 두개의 세자리수를 곱해서 나온 결과가 palindrome일때
	// 가장 큰 palindrome 수와 어떤 수를 곱해서 나온 결과인가? = 회문 기러기 우영우 스위스 토마토 등이 회문임
	// 100~999 x 100~999 = 906609

	public static void main(String[] args) {
	
//	static boolean isPalindrome(String str) {
//		return str.equals(reverse(str));
//	}
//		static String reverse(String str) {
//			String reverseStr = "";
//			for (int i = str.length() -1; i >= 0; i--)
//				reverseStr += str.charAt(i);
//			return reverseStr;
//			System.out.println();
		
	
		
		int palSum = 0;
		int palsum1 = 0;
		int palsum2 = 0;
		for (int i = 100; i <= 999; i++) {
			for (int k = 100; k <= 999; k++) {
				if (pal(i * k) && (i * k) >= palSum) {
					palSum = i * k;
				}
			}
		}
		System.out.println(palSum);
	}

	public static boolean pal(int num) { // text 906609
		String num2 = String.valueOf(num);

		for (int i = 0; i < num2.length() / 2; i++) {
			if (num2.charAt(i) != num2.charAt(num2.length() - 1 - i)) { // 공식 == -1-i / 관계연산자, 증감 연산자 는 모든 언어 공통사항
				return false;
			}
		}
		return true;
	}
}



