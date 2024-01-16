package ch04_control;

public class Q2_학점Switch {
	public static void main(String[] args) {

		int score = 72;
		String grade = "";
		switch (score / 10) {

		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		default:
			grade = "F";
		}
		System.out.println("score: " + score + ", grade: " + grade);

	}
}