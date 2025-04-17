package banking6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class AutoSaver extends Thread {

	private AccountManager manager;
	
	
	
	public AutoSaver(AccountManager manager) {
		this.manager = manager;
		setDaemon(true);
	}


	@Override
	public void run() {
		
		while(true) {
			try {
				saveToFile();
				sleep(5000);
			}
			catch (InterruptedException e) {
				System.out.println("*** 자동저장을 종료합니다. ***");
				break;
			}
		}
	}
	
	public void saveToFile() {
		try (PrintWriter out =
				new PrintWriter(
						new FileWriter("src/banking6/AutoSaveAccount.txt"))){
			Iterator<Account> it = 
						manager.getAccounts().iterator();
			while (it.hasNext()) {
				Account acc = it.next();
				out.println(acc);
			}
			System.out.println("계좌정보가 텍스트로 자동저장되었습니다.");
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	
}
