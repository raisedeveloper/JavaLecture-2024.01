package ch14_exception;

public class Ex02_Unchecked { 					// 런타임 시 에러나도 끝까지 굴러가게 해주는 것

	public static void main(String[] args) {
		try {
			System.out.println(3 / 0);
		} catch (Exception e) {
			e.printStackTrace(); 				// 이게 뭐임???????? _ 에러 도출 메소드
		}

		
		int[] intArray = new int[3];
		try {
			System.out.println(intArray[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		
		String str = null;						 // null 인데 access 하리니까 오류날 것임
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		
		str = "100원";
		try {
			int value = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		try {
			Cat cat = (Cat) a1;
			cat = (Cat) a2;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램의 마지막입니다.");
	}

}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
