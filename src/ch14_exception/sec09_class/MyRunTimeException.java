package ch14_exception.sec09_class;

public class MyRunTimeException extends RuntimeException{
	// 사용자 정의 예외 클래스 작성 및 발생 방법 _ 예외를 발생시키는 방법

	public MyRunTimeException() {
	}

	public MyRunTimeException(String message) {
		super(message);
	}

}
