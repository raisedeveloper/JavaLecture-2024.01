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

		Account account = new Account(accNum, accOwner, balance);
		account.setAccNum(accNum); // class에 만들어놓은 getter setter 메서드로 값 변경함
		account.setAccOwner(accOwner);
		account.setBalance(balance);
		AccountArray[0] = account; // 0번째에 넣은것임 _ 이 자리에 For문 진행해야함 (for () 쓴다면)

		System.out.println(AccountArray[0].getAccOwner());
		// accList(AccountArray);
		Deposit(AccountArray);
	}

	public void accList(Account[] AccountArray) { // void 는 리턴타입이 없음 _ 여기서 동작되고 끝남
		for (int i = 0; i < AccountArray.length; i++) {
			if (AccountArray[i] != null) {
				System.out.println("계좌번호" + AccountArray[i].getAccNum() + AccountArray[i].getAccOwner()
						+ AccountArray[i].getBalance());
			} else {
				break;
			}
		}
	}

	public void Deposit(Account[] AccountArray) {
		System.out.println("계좌 번호를 입력해주세요.");
		int accNum = Integer.parseInt(scan.nextLine());
		Account acc = null;
		for (int i = 0; i < AccountArray.length; i++) {
			if (AccountArray[i] != null) {
				if (AccountArray[i].getAccNum() == accNum) { // private 는 바로 못가져옴 접근 제어자 _ 같은 클래스 내에서만 가능해서 'get'써야함
					System.out.println("입금액을 입력하세요.");
					int accBalance = Integer.parseInt(scan.nextLine());
					AccountArray[i].setBalance(AccountArray[i].getBalance() + accBalance); // 리팩토링임
					System.out.println("입금이 완료되었습니다.");
					acc = AccountArray[i];
					break;

					// refactoring 찐임
					// int inputBalance = AccountArray[i].getBalance() + accBalance;
					// AccountArray[i].setBalance(inputBalance);
				}
			}
		}
		if (acc == null) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
	}

	
	
	큰지 작은지 확인하는 과정@! 디자인 보고 하기
}

// 1.계좌생성♥  2.계좌목록♥ 까지 해보기 1/23까지