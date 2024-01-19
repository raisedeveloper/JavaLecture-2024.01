package ch09_modifier.sec3_static;

public class Sample {
	int instanceField;
	public static final int STATIC_FIELD = 1234;

	void instanceMethod() {
		System.out.println("instance method");
	}

	// 이하는 왠만해서는 쓰지마라
	static void staticMethod() {
		System.out.println("static method");
	}

}
