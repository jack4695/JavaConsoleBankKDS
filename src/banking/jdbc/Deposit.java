package banking.jdbc;

import java.sql.SQLException;

public class Deposit extends MyConnection {

	public Deposit(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	public void dbExecute() {
		try {
			//인파라미터가 있는 쿼리문 작성
			query = " UPDATE banking "
					+ " SET balance = (balance+(balance*interest)+?) "
					+ " WHERE acNum=? " ;
			//작성된 쿼리문을 기반으로 Prepared인스턴스 생성
			psmt = con.prepareStatement(query);
			//exit를 입력하기전까지는 무한히 반복실행
			while(true) {
				//입력값을 통해 인파라미터 설정
				psmt.setString(2, inputValue("입금할 계좌번호"));
				psmt.setString(1, inputValue("입금액"));
				//Prepared 인스턴스를 통해 쿼리문 실행
				result = psmt.executeUpdate();
				System.out.println("[psmt]"+ result
											+"행 업데이트됨");
				System.out.println("입금이 완료되었습니다.");
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Deposit("education", "1234").dbExecute();
	}
}
