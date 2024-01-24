package ch14_exception;

public class Ex05_MultiCatch2 {			// 멀티 캐치로 받는 방법

	public static void main(String[] args) {
		int value = 0;

		try {
			value = Integer.parseInt(args[0]);		// 이 문장에서 에러남
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			//ArrayIndexOutOfBoundsException | NumberFormatException 한 번에 조건을 입력 | (or)
			e.printStackTrace();
			System.out.println("사용법 : 매개변수가 필요하고 숫자를 입력해야 합니다.");
		}
		System.out.println(value);
	}

}
