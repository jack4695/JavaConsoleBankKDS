package banking.jdbc;

import java.sql.SQLException;
import java.sql.Types;

public class Withdraw extends MyConnection {

	public Withdraw(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			//프로시저 호출
			csmt = con.prepareCall("{call pcd_withdraw(?,?,?)}");
			//인파라미터 설정
			csmt.setString(1, inputValue("출금할 계좌번호"));
			csmt.setString(2, inputValue("출금액"));
			//아웃파라미터 설정 : 반환값에 타입에 대한 설정
			csmt.registerOutParameter(3, Types.VARCHAR);
			//실행
			csmt.execute();
			System.out.println(csmt.getString(3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose();
		}
	}
	
	public static void main(String[] args) {
		new Withdraw("education", "1234").dbExecute();
	}
}
