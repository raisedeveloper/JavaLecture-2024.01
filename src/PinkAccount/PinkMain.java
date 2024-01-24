package PinkAccount;

import java.util.Scanner;

public class PinkMain {

	public static void main(String[] args) {
		Account[] accountArray = new Account[100];		// main에 있는 accountArray < 계좌정보들이 순서대로 들어가 있을 공간
														// 계좌 생성 후 accountArray로 들어갈 예정
		System.out.println("+=================================================================+");
		System.out.println("|====== 1.계좌생성♥  2.계좌목록♥  3.예금♥  4.출금♥  5.종료♥ ======|");
		System.out.println("+=================================================================+");
		
		
		Scanner scan = new Scanner(System.in);			// 고객이 선택할 수 있는 화면 호출
		PinkService ps = new PinkService();
		System.out.println("♥ 목록 선택 ♥ >> ");		// 목록 선택 메세지창 호출
		
		int name = Integer.parseInt(scan.nextLine());	// 입력받은 값 강제 숫자 형변환선택할 순번 타이핑 영역 생성
		
				// 사용 후 닫기
			
		if(name == 1) {
			ps.setAcc(accountArray);			// service 단에 작성된 메서드를 사용하기 위해 호출함
		}
		
		
		
	
		
		
		



	

}
}