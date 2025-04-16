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
			}
		}
	}
	
	public void saveToFile() {
		try (PrintWriter out =
				new PrintWriter(
						new FileWriter("AutoSaveAccount.txt"))){
			Iterator<Account> it = 
						manager.getAccounts().iterator();
			while (it.hasNext()) {
				Account acc = it.next();
				out.println(acc);
			}
			System.out.println("*** 자동저장 완료 ***");
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	
}
