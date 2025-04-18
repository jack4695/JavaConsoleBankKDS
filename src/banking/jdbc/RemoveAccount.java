package banking.jdbc;

import java.sql.SQLException;
import java.sql.Types;

public class RemoveAccount extends MyConnection {
	
	public RemoveAccount(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			//프로시저 호출
			csmt = con.prepareCall("{call pcd_remove(?,?)}");
			//인파라미터 설정
			csmt.setString(1, inputValue("삭제할 계좌번호"));
			csmt.registerOutParameter(2, Types.VARCHAR);
			//실행
			csmt.execute();
			
			System.out.println(csmt.getString(2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new RemoveAccount("education", "1234").dbExecute();

	}

}
