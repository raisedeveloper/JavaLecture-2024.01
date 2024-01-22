package ch12_interface.sec11_bank;

public class Account implements AccountService {
	private String ano;
	private String owner;
	private int balance;

	public Account() {
	}

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

	@Override
	public void createAccount(String ano, String owner, int balance, Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 생성");
		System.out.println("----------");

		Account account = new Account(ano, owner, balance);

		accountArray[BankMain.index++] = account;

		System.out.println("계좌가 생성되었습니다.");
	}

	@Override
	public void accountList(Account[] accountArray) {
		System.out.println("----------");
		System.out.println("계좌 목록");
		System.out.println("----------");

		for (int i = 0; i < BankMain.index; i++) {
			Account acc = accountArray[i];
			System.out.printf("%s %-6s\t %,10d\n", acc.getAno(), acc.getOwner(), acc.getBalance());
		}
	}

	@Override
	public void deposit(String ano, int amount, Account[] accountArray) {
		System.out.println("----------");
		System.out.println("---예금---");
		System.out.println("----------");

		Account account = findAccount(ano, accountArray);
		if (account == null) {
			System.out.println("계좌번호를 확인하세요.");
			return;
		}

		account.setBalance(amount + account.getBalance());
		System.out.println("예금 완료");
	}

	@Override
	public void withdraw(String ano, int amount, Account[] accountArray) {
		System.out.println("----------");
		System.out.println("---출금---");
		System.out.println("----------");

		Account account = findAccount(ano, accountArray);
		if (account == null) {
			System.out.println("계좌번호를 확인하세요.");
			return;
		}

		if (account.getBalance() >= amount) {
			account.setBalance(account.getBalance() - amount);
			System.out.println("출금이 완료되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
		}
	}

	@Override
	public Account findAccount(String ano, Account[] accountArray) {
		for (Account acc : accountArray) {
			if (acc == null)
				return null;
			if ((ano.equals(acc.getAno())))
				return acc;
		}
		return null;
	}
}