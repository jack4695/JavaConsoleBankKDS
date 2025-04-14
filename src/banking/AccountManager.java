package banking;


public class AccountManager {
	
	/*
	계좌 정보들을 저장하기 위한 인스턴스형 배열을 생성. 
	각각의 배열이 필요하고, 카운트를 위한 변수도 생성한다.
	*/
	private Account[] accounts;
	private int numOfaccount;
	
	//생성자 : 배열의 크기를 결정할 값을 매개변수로 받아서 초기화
	public AccountManager (int num) {
		//num의 크기로 배열이 생성된다.
		accounts = new Account[num];
		//입력된 정보의 갯수(or 인덱스) 카운트를 위한 변수
		numOfaccount = 0;
		
	}
	
	public void makeAccount() {   // 계좌개설을 위한 함수
		
		//Scanner scan = new Scanner(System.in);
		//입력값을 저장할 변수 생성
		String iAccountNum;
		String iName;
		int iBalance;
		
		//정보 3가지를 입력받음
		System.out.println("계좌번호:");
			iAccountNum = BankingSystemMain.scan.nextLine();
		System.out.println("이름:");
			iName = BankingSystemMain.scan.nextLine();
		System.out.println("잔액:");
			iBalance = BankingSystemMain.scan.nextInt();
			
		// Account 인스턴스 생성
		Account ac =
			new Account(iAccountNum, iName, iBalance);
		
		/*
		인스턴스 참조값을 배열에 추가. 카운트용 변수를 후위증가 시켜 0번
		인덱스에 먼저 입력된 후 1증가하게된다. */
		accounts[numOfaccount++] = ac;
		
		System.out.println("##계좌정보 입력이 완료되었습니다##");	
		
	};
	
	public void depositMoney() {  //입금
		
		// 1. 계좌번호 입력받기
	    System.out.print("입금할 계좌번호를 입력하세요: ");
	    String acNum = BankingSystemMain.scan.nextLine();

	    // 2. 입금할 금액 입력받기
	    System.out.print("입금할 금액을 입력하세요: ");
	    int plusMoney = BankingSystemMain.scan.nextInt();

	    // 3. 입력된 계좌번호로 계좌 찾기
	    for (int i = 0; i < numOfaccount; i++) {
	        if (accounts[i].getAccountNum().equals(acNum)) {
	            // 4. 계좌가 있으면 입금 진행
	            accounts[i].deposit(plusMoney);
	            System.out.println("입금 완료! 현재 잔액: " + accounts[i].getBalance());
	            return;
	        }
	    }
	    
	    // 5. 계좌 못 찾았을 경우
	    System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	};
	
	public void withdrawMoney() {  // 출금
		
		// 1. 계좌번호 입력받기
	    System.out.print("출금할 계좌번호를 입력하세요: ");
	    String acNum = BankingSystemMain.scan.nextLine();

	    // 2. 출금할 금액 입력받기
	    System.out.print("출금할 금액을 입력하세요: ");
	    int minusMoney = BankingSystemMain.scan.nextInt();

	    // 3. 입력된 계좌번호로 계좌 찾기
	    for (int i = 0; i < numOfaccount; i++) {
	        if (accounts[i].getAccountNum().equals(acNum)) {
	            // 4. 계좌가 있으면 출금 진행
	            accounts[i].withdraw(minusMoney);
	            System.out.println("출금 완료! 현재 잔액: " + accounts[i].getBalance());
	            return;
	        }
	    }
	    
	    // 4. 계좌 못 찾았을 경우
	    System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	};
	
	public void showAccInfo() {    // 전체계좌정보출력
		
		/*
		저장된 정보의 갯수만큼 반복해서 전체정보를 출력한다. */
		for(int i=0 ; i<numOfaccount ; i++) {
			accounts[i].showAccountData();
		}
		
		System.out.println("##전체계좌정보가 출력되었습니다##");
	};
	
	
	
	
	
	

}
