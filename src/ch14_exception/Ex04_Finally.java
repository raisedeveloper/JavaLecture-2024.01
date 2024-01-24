package ch14_exception;

public class Ex04_Finally {

	public static void main(String[] args) {
		String str = null;
		try {
			str = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("사용법 : 매개변수를 입력하세요.");
		}
		System.out.println(str);

		int value = 0;
		try {
//			int value = Integer.parseInt(str);
			System.out.println(value); // int가 있는 영역 안에서만 유효한 메서드라서 다른 곳에 있으면 오류남
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("사용법 : 숫자만 입력하세요.");
		} finally {
			System.out.println("예외와 상관없이 무조건 실행됩니다.");		// 자바에서 리소스에 에러나면 cross 를 'finally'에 넣으면 돌아감
		}
		System.out.println(value);
	}

}

// Run configurations> Program arguments 에 10 찍으면 10 출력됨