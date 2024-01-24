package ch14_exception;

public class Ex07_General {			

	public static void main(String[] args) {
		int value = 0;
		try {
			
		} catch (Exception e) {						// 모든 예외의 조상 = Exception 임
		}
		try {
			value = Integer.parseInt(args[0]);		// 이 문장에서 에러남
		} catch (Exception e) {
		//ArrayIndexOutOfBoundsException | NumberFormatException 이렇게 길게 쓸 필요없이 Exception 써서 실행
			e.printStackTrace();
			System.out.println("사용법 : 매개변수가 필요하고 숫자를 입력해야 합니다.");
		}
		System.out.println(value);
	}

}
