package banking;

import java.util.Scanner;

public class BankingSystemMain {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.계좌개설 ");
		System.out.println("2.입금 ");
		System.out.print("3.출금 ");
		System.out.println("4.전체계좌정보출력 ");
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
			case 1:
				manager.makeAccount();
				break;
			case 2:
				manager.depositMoney();
				break;
			case 3:
				manager.withdrawMoney();
				break;
			case 4:
				manager.showAccInfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
