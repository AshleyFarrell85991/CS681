import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ThreadSafeBankAccount2 bankaccount = new ThreadSafeBankAccount2();
		DepositRunnable dr = new DepositRunnable(bankaccount);
		WithdrawRunnable wr = new WithdrawRunnable(bankaccount);
		ArrayList<Thread> threads = new ArrayList<>();
		for(int i = 0 ; i < 11; i++) {
			
			Thread t = new Thread(dr);
			Thread t2 = new Thread(wr);
			threads.add(t);
			threads.add(t2);
			t2.start();
			t.start();

		}
		
		for(int i = 0; i < 11 ; i++) {
			
			threads.get(i).interrupt();
		}
		
		dr.setDone();
		wr.setDone();
		
		
     for(int i = 0 ; i < 11 ; i++) {
    	 
try {
	
	threads.get(i).join();
}catch(InterruptedException e) {
	
}

     }
		
		
	}
	
	}

