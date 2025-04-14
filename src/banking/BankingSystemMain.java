package banking;

import java.util.Scanner;

public class BankingSystemMain implements Menu {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설 ");
		System.out.println("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.println("4.계좌정보출력 ");
		System.out.print("5.프로그램종료 ");
		
	}

	public static void main(String[] args) {

		AccountManager manager = new AccountManager(50);

		/*무한루프로 while문 작성.*/
		while(true) {
			//제일 먼저, 메뉴를 출력
			showMenu();
			//메뉴 입력
			int choice = scan.nextInt();
			//입력을 위한 버퍼(Buffer) 제거
			scan.nextLine();
			
			switch(choice) {
			case MAKE:
				manager.makeAccount();
				break;
			case DEPOSIT:
				manager.depositMoney();
				break;
			case WITHDRAW:
				manager.withdrawMoney();
				break;
			case INQUIRE:
				manager.showAccInfo();
				break;
			case EXIT:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
