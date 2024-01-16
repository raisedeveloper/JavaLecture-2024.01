package ch04_control;

public class Ex01_If {

	public static void main(String[] args) {
		int score = 60 + (int) (41 * Math.random()); // 60 ~ 100

		if (score >= 80)
			System.out.println(score + "점은 평균 이상입니다.");
		else
			System.out.println(score + "점은 평균 이상입니다.");

		char grade = 0;
		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else if (score >= 50)
			grade = 'F';
		System.out.println("score: " + score + ", grade: " + grade);

		switch (score / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		default:
			grade = 'D'; // 맨 마지막 경우는 기본값이기 때문에 break가 필요X

		}
	}

}