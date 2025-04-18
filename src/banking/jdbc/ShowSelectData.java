package banking.jdbc;

import java.sql.SQLException;

public class ShowSelectData extends MyConnection {

	public ShowSelectData(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			while(true) {
				String S_account = "SELECT * FROM banking "
						+ " WHERE acNum = ? ";
				
				psmt = con.prepareStatement(S_account);
				psmt.setString(1, inputValue("조회할 계좌번호"));
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String no = rs.getString("no");
					String acNum = rs.getString("acNum");
					String name = rs.getString("name");
					String balance = rs.getString("balance");
					String interest = rs.getString("interest");
					
					System.out.printf("%s %s %s %s %s\n",
							no, acNum, name, balance, interest);
				}
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ShowSelectData("education", "1234").dbExecute();

	}

}
