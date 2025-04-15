package banking;

public abstract class Account {
	
	String accountNum;
	String name;
	int balance;
	
	//생성자
	public Account(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	
	
	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// toString 오버라이드
		@Override
		public String toString() {
			return "Account [계좌번호=" + accountNum +
					", 이름=" + name + ", 잔고=" + balance + "]";
		}
	
	public int deposit(int money) {
		balance += money; // 기존 balance에 입금 금액 추가
	    return balance;   // 입금 후 잔액 반환
	}
	
	public int withdraw(int money) {
		if (money<=balance) {
			balance -= money; // 기존 balance에 출금 금액 빼기
			return balance;   // 출금 후 잔액 반환
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
		return -1;    //이해는 안가지만 일단 해봄. (출금실패 에러값)
	}


	// 출력용 메서드
	public void showAccountData() {
		System.out.println("계좌번호:"+ accountNum);
		System.out.println("이름:"+ name);
		System.out.println("잔액:"+ balance);
	}
}
