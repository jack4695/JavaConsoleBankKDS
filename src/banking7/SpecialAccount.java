package banking7;

public class SpecialAccount extends NormalAccount {
	
	int bonus = 500 ; //축하금 500원
	int count ; //몇회차 입금인지 카운트
	
	public SpecialAccount(String accountNum, String name,
								int balance, int interest,
								int count) {
		super(accountNum, name, balance, interest);
		
		this.count = count ;
	}
	
	@Override
	public int deposit(int money) {
		
		++count;
		if (count%2 != 0) {
			balance = (balance + (balance * interest)/100 + money);
		}
		else {
			balance = (balance + (balance * interest)/100 +
												money + bonus); 
		}
		return balance;
		
	}
	
	@Override
	public int withdraw(int money) {
		if (money<=balance) {
			balance -= money; 
			return balance; 
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
		return -1;    //이해는 안가지만 일단 해봄. (출금실패 에러값)
	}
	
	@Override
	public void showAccountData() {
		super.showAccountData();
		System.out.println("현재 입금회차 : " + count);
	}
	
}
