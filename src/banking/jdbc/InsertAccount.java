package banking.jdbc;

import java.sql.SQLException;

//DB연결을 위한 MyConnection 클래스 상속
public class InsertAccount extends MyConnection {
	
	public InsertAccount(String user, String pass) {
		super(user, pass);
	}
	//멤버변수
	String query; //쿼리문 작성
	int result;	  //쿼리 실행 후 결과 반환
	
	//insert 쿼리문 실행을 위한 메서드
	@Override
	public void dbExecute() {
		try {
			//인파라미터가 있는 동적쿼리문 작성
			query = "INSERT INTO banking VALUES "
					+ " (?, ?, ?, ?, ?)";
			/*
			preparedStatement 인터페이스
			: 인파라미터가 있는 동적쿼리문을 실행할때 사용한다.
			인파라미터는 ?로 표시하고, 인스턴스 생성 이후 setXX() 메서드를
			통해 설정한다. 인덱스는 1부터 시작한다.
			*/
			psmt = con.prepareStatement(query);
			//쿼리문의 인파라미터 입력값을 통해 설정함.
			psmt.setString(1, inputValue("일련번호"));
			psmt.setString(2, inputValue("계좌번호"));
			psmt.setString(3, inputValue("이름"));
			psmt.setString(4, inputValue("잔액"));
			psmt.setString(5, inputValue("이자율"));
			//쿼리문 실행 및 결과 반환
			result = psmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
		finally {
			dbClose();
		}
	}
	//정의된 클래스의 인스턴스를 생성하여 실행한다.
	public static void main(String[] args) {
		new InsertAccount("education", "1234").dbExecute();
	}
}
