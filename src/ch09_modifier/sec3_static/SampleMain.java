package ch09_modifier.sec3_static;

public class SampleMain {

	public static void main(String[] args) {
		// 인스턴스 필드와 메소드를 사용하는 벙법
		Sample sample = new Sample();
		System.out.println(sample.instanceField);

		// 스태틱 필드, 메소드를 사용하는 방법
		System.out.println(Sample.STATIC_FIELD);
		Sample.staticMethod();

	}

}
