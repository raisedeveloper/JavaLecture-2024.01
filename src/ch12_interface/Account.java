package ch12_interface;

import java.util.Scanner;

public class Account implements AccountService {
	private String ano;
	private String owner;
	private int balance;

	public Account() { }
	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static Scanner getScan() {
		return scan;
	}

	public static void setScan(Scanner scan) {
		Account.scan = scan;
	}

	private static int index = 0;
	private static Scanner scan = new Scanner(System.in);
	private static Account[] accountArray = new Account[100];

	@Override
	public void createAccount(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		String ano = "" + (1000 + index);
		System.out.print("계좌주 이름>");
		String owner = scan.nextLine();
		System.out.print("최초 입금액>");
		int balance = Integer.parseInt(scan.nextLine());
		Account account = new Account(ano, owner, balance);

		Account.accountArray[index++] = account;

		System.out.println("계좌가 생성되었습니다.");
	}

	@Override
	public void accountList(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("계좌 목록");
		System.out.println("-----------");

		for (int i = 0; i < index; i++) {
			Account acc = Account.accountArray[i];
			System.out.printf("%s %-26s\t%,10d%n", acc.getAno(), acc.getOwner(), acc.getBalance());
		}
	}

	@Override
	public void deposit(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("입금");
		System.out.println("-----------");

		System.out.print("계좌 번호> ");
		String ano = scan.nextLine();
		System.out.print("입금액> ");
		int balance = Integer.parseInt(scan.nextLine());
		if (balance <= 0) {
			System.out.println("-는 사용할수없습니다.");
			return;
		}
		Account account = findAccount(ano, Account.accountArray);
		if (account == null) {
			System.out.println("계좌번호를 확인하세요.");
			return;
		}
		account.setBalance(balance + account.getBalance());
		System.out.println("입금이 완료되었습니다.");

	}

	@Override
	public void withdraw(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");

		System.out.print("계좌 번호> ");
		String ano = scan.nextLine();
		System.out.print("출금액> ");
		int balance = Integer.parseInt(scan.nextLine());
		if (balance <= 0) {
			System.out.println("-는 사용할수없습니다.");
			return;
		}
		Account account = findAccount(ano, Account.accountArray);
		if (account == null) {
			System.out.println("계좌번호를 확인하세요.");
			return;
		}
		if (account.getBalance() >= balance) {
			account.setBalance(account.getBalance() - balance);
			System.out.println("출금이 완료되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
		}

	}

	@Override
	public Account findAccount(String ano, Account[] accountArray) {
		for (int i = 0; i <= index; i++)
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			}
		return null;
	}

}
