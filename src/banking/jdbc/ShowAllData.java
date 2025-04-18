package banking.jdbc;

import java.sql.SQLException;

public class ShowAllData extends MyConnection {
	
	public ShowAllData(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	@Override
	public void dbExecute() {
		try {
			stmt = con.createStatement();
			//쿼리문 작성
			String query = " SELECT * FROM banking";
			//쿼리문을 실행한 후 결과는 ResultSet으로 반환
			rs = stmt.executeQuery(query);
			//반복 인출
			while(rs.next()) {
				//인출시 인덱스와 컬럼명으로 표현
				String no = rs.getString("no");
				String acNum = rs.getString("acNum");
				String name = rs.getString("name");
				String balance = rs.getString("balance");
				String interest = rs.getString("interest");
				
				System.out.printf("%s %s %s %s %s\n",
						no, acNum, name, balance, interest);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ShowAllData("education", "1234").dbExecute();

	}

}
