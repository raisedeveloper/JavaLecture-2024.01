package PinkAccount;

public class Account { 
	// 계좌 정보가 들어갈 Account 클래스

	private int accNum;
	private String accOwner;
	private int balance;
	
	
	public Account() { }

	public Account(int accNum, String accOwner, int balance) {
		super();
		this.accNum = accNum;
		this.accOwner = accOwner;
		this.balance = balance;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(String accOwner) {
		this.accOwner = accOwner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
