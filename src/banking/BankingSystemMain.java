package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
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
			try {
				int choice = scan.nextInt();
				//입력을 위한 버퍼(Buffer) 제거
				scan.nextLine();
				
				if (choice < 1 || choice > 5) {
                    throw new MenuSelectException();
                }
				
				switch(choice) {
				case ICustomDefine.MAKE:
					manager.makeAccount();
					break;
				case ICustomDefine.DEPOSIT:
					manager.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					manager.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					manager.showAccInfo();
					break;
				case ICustomDefine.EXIT:
					System.out.println("프로그램종료");
					return;
				}
			}
			catch (InputMismatchException e) {
                System.out.println("예외발생: 숫자만 입력하세요.");
                scan.nextLine(); // 버퍼 비우기
            } catch (MenuSelectException e) {
                System.out.println("예외발생: " + e.getMessage());
            }
		}
	}
}
