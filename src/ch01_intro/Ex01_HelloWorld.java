package ch01_intro;

// class 이름 Ex01_HelloWorld 대문자로 시작
public class Ex01_HelloWorld {

	/**
	 * 도큐먼트 주석 - API document 만들 때 사용
	 * 
	 * @param args
	 */
	// method 이름 main은 소문자로 시작
	public static void main(String[] args) {
		// sysout, syso 를 타이핑 한 후 ctrl + space 치면 System.out.println(); 생성
		System.out.println("Hello World!!!"); // 문장 끝에는반드시 세미콜론(;) 붙임
		/*
		 * 여러줄의 주석
		 */
		System.out.println("안녕하세요? " + "여러분!!!"); // 하나의 문자열만 올 수 있음 (두개 이상일 경우에는 + 연산자를 사용함)
		System.out.println(); // ctrl + / : 문장 커멘트 처리 유무 (토글)
	}

}
