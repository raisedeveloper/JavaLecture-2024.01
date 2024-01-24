package ch12_interface.sec11_bank;

import java.util.Scanner;

public class BankMain {
	private static Account[] accountArray = new Account[100];
	static Scanner scan = new Scanner(System.in);
	static int index = 3;

	public static void main(String[] args) {
		boolean run = true;
		accountArray[0] = new Account("1000", "제임스", 10000);
		accountArray[1] = new Account("1001", "마리", 300000);
		accountArray[2] = new Account("1002", "브라이언", 2000000);

		AccountService accountService = new Account(); // AccountService 인터페이스로 선언
		while (run) {
			System.out.println("+============+=============+=========+=========+=========+");
			System.out.println("|1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 |");
			System.out.println("+============+=============+=========+=========+=========+");
			System.out.println("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			
			switch (selectNo) {
			case 1:
				System.out.print("계좌주 이름> ");
				String owner = scan.nextLine();
				System.out.print("최초 입금액> ");
				int balance = Integer.parseInt(scan.nextLine());
				accountService.createAccount("" + (1000 + BankMain.index), owner, balance, accountArray);
				break;
			case 2:
				accountService.accountList(accountArray);
				break;
			case 3:
				System.out.println("계좌 번호> ");
				String depositAno = scan.nextLine();
				System.out.print("예금액> ");
				int depositAmount = Integer.parseInt(scan.nextLine());
				accountService.deposit(depositAno, depositAmount, accountArray);
				break;
			case 4:
				System.out.println("계좌 번호> ");
				String withdrawAno = scan.nextLine();
				System.out.print("출금액> ");
				int withdrawAmount = Integer.parseInt(scan.nextLine());
				accountService.withdraw(withdrawAno, withdrawAmount, accountArray);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("Warning: 1부터 5사이의 숫자를 입력하세요");
			}
		}
		System.out.println("프로그램 종료");
	}
}