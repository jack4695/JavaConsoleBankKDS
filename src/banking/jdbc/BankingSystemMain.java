package banking.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설 ");
		System.out.println("2.입 금 ");
		System.out.println("3.출 금 ");
		System.out.println("4.전체 계좌정보출력 ");
		System.out.println("5.지정 계좌정보출력 ");
		System.out.println("6.프로그램종료 ");
	}

	public static void main(String[] args) {
		
		/*무한루프로 while문 작성.*/
		while(true) {
			//제일 먼저, 메뉴를 출력
			showMenu();
			//메뉴 입력
			try {
				int choice = scan.nextInt();
				//입력을 위한 버퍼(Buffer) 제거
				scan.nextLine();
				
				if (choice < 1 || choice > 6) {
                    throw new MenuSelectException();
                }
				
				switch(choice) {
				case ICustomDefine.MAKE:
					new InsertAccount("education", "1234").dbExecute();
					break;
				case ICustomDefine.DEPOSIT:
					new Deposit("education", "1234").dbExecute();
					break;
				case ICustomDefine.WITHDRAW:
					new Withdraw("education", "1234").dbExecute();
					break;
				case ICustomDefine.INQUIRE:
					new ShowAllData("education", "1234").dbExecute();
					break;
				case ICustomDefine.SEARCH:
					new ShowSelectData("education", "1234").dbExecute();
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
