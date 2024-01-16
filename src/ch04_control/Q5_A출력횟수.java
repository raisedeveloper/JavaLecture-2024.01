package ch04_control;

public class Q5_A출력횟수 {
	public static void main(String[] args) {
		

		for(int i = 0;i<5;i++)
			for(int k = 0;k<3;k++)
			{
				if(i == 2) {
					continue;
			}
			
				if(k == 1) {
					break;
				}
				System.out.println("A");

			}
	}
}