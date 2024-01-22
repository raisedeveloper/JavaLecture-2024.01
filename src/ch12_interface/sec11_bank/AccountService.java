package ch12_interface.sec11_bank;

public interface AccountService {
	void accountList(Account[] accountArray);

	void createAccount(String ano, String owner, int balance, Account[] accountArray);

	void deposit(String ano, int amount, Account[] accountArray);

	void withdraw(String ano, int amount, Account[] accountArray);

	Account findAccount(String ano, Account[] accountArray);

}