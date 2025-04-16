package banking6;

public class HighCreditAccount extends Account {
	
	int interest ; //기본이자
	int extraInterest ; //추가이자
	String creditRate ; //신용등급
	
	
	public HighCreditAccount(String accountNum, String name,
		int balance, int interest,
		int extraInterest, String creditRate) {
		
		super(accountNum, name, balance);
		
		this.interest = interest;
		this.extraInterest = extraInterest;
		this.creditRate = creditRate;
		
	}
	
	@Override
	public int deposit(int money) {
		
		balance = (balance + (balance * interest)/100 
						+ (balance * extraInterest)/100 + money); 
	    return balance;   // 입금 후 잔액 반환
	}
	
	@Override
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
	
	@Override
	public void showAccountData() {
		super.showAccountData();
		System.out.println("기본이자:"+ interest + "%");
		System.out.println("신용등급:"+ creditRate);
	}

}
