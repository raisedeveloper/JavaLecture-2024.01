package PinkAccount;

import java.util.Scanner;

public class PinkService {
	Scanner scan = new Scanner(System.in); // 필드에 선언

	public void setAcc(Account[] AccountArray) { // Main에서 매개변수로 넘겨받은 accountArray를 사용가능하다
													// Main에서 사용하기 위한 메서드를 작성함
		System.out.println("계좌 정보를 입력하세요.");
		System.out.print("계좌주 > ");
		String accOwner = scan.nextLine();

		System.out.print("계좌번호 > ");
		int accNum = Integer.parseInt(scan.nextLine()); // .nextLine = String형 >> 스캔 입력값 int형으로 변환

		System.out.println("초기 입금액> ");
		int balance = Integer.parseInt(scan.nextLine());
		
		Account account = new Account();
		account.setAccNum(accNum);		// class에 만들어놓은 getter setter 메서드로 값 변경함
		account.setAccOwner(accOwner);
		account.setBalance(balance);
		AccountArray[0] = account;			// 0번째에 넣은것임 _ 이 자리에 For문 진행해야함 (for () 쓴다면)
		
		System.out.println(AccountArray[0].getAccOwner());
		
	}

}
// 1.계좌생성♥  2.계좌목록♥ 까지 해보기 1/23까지