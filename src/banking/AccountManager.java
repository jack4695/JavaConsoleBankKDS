package banking;

import java.util.HashSet;
import java.util.InputMismatchException;

public class AccountManager {
	
	private HashSet<Account> accounts = new HashSet<>();
	
	public AccountManager (int num) {
		accounts = new HashSet<>();
	}
	
	public void makeAccount() {   // 계좌개설을 위한 함수
		
		//입력값을 저장할 변수 생성
		String iAccountNum;
		String iName;
		int iBalance;
		
		int iInterest;
		int iExtraInterest;
		String iCreditRate;
		
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1. 보통계좌");
		System.out.println("2. 신용신뢰계좌");
		
		int choice = BankingSystemMain.scan.nextInt();
	    BankingSystemMain.scan.nextLine();
		
		if (choice==1) {
			
			System.out.println("계좌번호:");
			iAccountNum = BankingSystemMain.scan.nextLine();
			System.out.println("이름:");
			iName = BankingSystemMain.scan.nextLine();
			System.out.println("잔액:");
			iBalance = BankingSystemMain.scan.nextInt();
			System.out.println("기본이자%(정수형태로 입력):");
			iInterest = BankingSystemMain.scan.nextInt();
			// Account 인스턴스 생성
			NormalAccount ac =
				new NormalAccount(iAccountNum, iName,
									iBalance, iInterest);
			accounts.add(ac); 
		}
		else if (choice==2) {
			System.out.println("계좌번호:");
			iAccountNum = BankingSystemMain.scan.nextLine();
			System.out.println("이름:");
			iName = BankingSystemMain.scan.nextLine();
			System.out.println("잔액:");
			iBalance = BankingSystemMain.scan.nextInt();
			System.out.println("기본이자%(정수형태로 입력):");
			iInterest = BankingSystemMain.scan.nextInt();
			
			BankingSystemMain.scan.nextLine(); //줄바꿈오류땜에 추가
			
			System.out.println("신용등급(A,B,C등급):");
			iCreditRate = BankingSystemMain.scan.nextLine();
			
			if (iCreditRate.equals("A")) {
				System.out.println("A");
				iExtraInterest = ICustomDefine.A;
				System.out.println(iExtraInterest);
			}
			else if (iCreditRate.equals("B")) {
				iExtraInterest = ICustomDefine.B;
			}
			else if (iCreditRate.equals("C")) {
				iExtraInterest = ICustomDefine.C;
			}
			else {
				System.out.println("잘못입력하셨습니다. ");
				return;
			}
			// Account 인스턴스 생성
			HighCreditAccount ac = new HighCreditAccount
						(iAccountNum, iName, 
							iBalance, iInterest,
							iExtraInterest, iCreditRate);
			accounts.add(ac);
		}
			
		
		System.out.println("계좌개설이 완료되었습니다.");	
		
	};
	
	public void depositMoney() {  //입금
		
	    	// 1. 계좌번호 입력받기
	    	System.out.print("입금할 계좌번호를 입력하세요: ");
	    	String acNum = BankingSystemMain.scan.nextLine();
	    	// 2. 입금할 금액 입력받기
	    	System.out.print("입금할 금액을 입력하세요: ");
	    	int plusMoney = BankingSystemMain.scan.nextInt();
	    	
	    	/********예외처리********/
	    	if (plusMoney < 0) {
	    		System.out.println("마이너스(-)금액은 입력할 수 없습니다.");
	    		return;
	    	};
	    	if (plusMoney%500 != 0) {
	    		System.out.println("500원 단위로만 입금이 가능합니다.");
	    		return;
	    	};
	    	// 3. 입력된 계좌번호로 계좌 찾고 입금하기
	    	for (Account acc : accounts) {
	    		if (acc.getAccountNum().equals(acNum)) {
	    			acc.deposit(plusMoney);
	    			System.out.println("입금 완료! 현재 잔액: " +
	    							acc.getBalance());
	    			return;
	    		}
	    	}
	    	// 4. 계좌 못 찾았을 경우
	    	System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	    
	   
	};
	
	public void withdrawMoney() {  // 출금
		
		// 1. 계좌번호 입력받기
	    System.out.print("출금할 계좌번호를 입력하세요: ");
	    String acNum = BankingSystemMain.scan.nextLine();

	    // 2. 출금할 금액 입력받기
	    System.out.print("출금할 금액을 입력하세요: ");
	    int minusMoney = BankingSystemMain.scan.nextInt();
	    
	    /********예외처리********/
	    if (minusMoney < 0) {
    		System.out.println("마이너스(-)금액은 입력할 수 없습니다.");
    		return;
    	};
    	
    	if (minusMoney%1000 != 0) {
    		System.out.println("1000원 단위로만 출금이 가능합니다.");
    		return;
    	};
    	
    	// 3. 출금할계좌 찾고 아래 예외 상황 처리
    	/*잔고보다 많은 금액을 출금요청할 경우 아래와 같이 처리한다.
			잔고가 부족합니다. 금액전체를 출금할까요?
			YES : 금액전체 출금처리
			NO : 출금요청취소
			*/
    	for (Account acc : accounts) {
    		if (acc.getAccountNum().equals(acNum)) {
    			int balance = acc.getBalance();
    			
    			if(minusMoney > balance) {
    				System.out.println("잔고가 부족합니다."
    						+ "금액전체를 출금할까요?"
    						+ "YES : 금액전체 출금처리 / "
    						+ "NO : 출금요청취소");
    				
    				BankingSystemMain.scan.nextLine(); // 줄바꿈 버그 방지
    				String answer = BankingSystemMain.scan.nextLine();
    				
    				if (answer.equals("YES")) {
    					acc.withdraw(balance);
    					System.out.println("금액전체 출금하였습니다.");
    				}
    				else {
    					System.out.println("출금이 취소되었습니다.");
    				}
    				return;
    			}
    			acc.withdraw(minusMoney);
    			System.out.println("출금 완료! 현재 잔액: " + acc.getBalance());
    			return;
    		}
    	}
	    
	    // 4. 계좌 못 찾았을 경우
	    System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	};
	
	public void showAccInfo() {    // 전체계좌정보출력
		
		/*
		저장된 정보의 갯수만큼 반복해서 전체정보를 출력한다. */
		for(Account acc : accounts) {
			acc.showAccountData();
		}
		
		System.out.println("##전체계좌정보가 출력되었습니다##");
	};
	
	
	
	
	
	

}
