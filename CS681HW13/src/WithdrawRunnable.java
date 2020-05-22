import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable{
	private ThreadSafeBankAccount2 account;
	private volatile boolean done = false;
	ReentrantLock lock = new ReentrantLock();
	public WithdrawRunnable(ThreadSafeBankAccount2 account) {
		this.account = account;
	}
	
	public void run(){
		lock.lock();

		while(true) {
			if(done) {
				break;
			}
		}
		try{
		
			for(int i = 0; i < 10; i++){
				account.withdraw(100.00);
				Thread.sleep(2);
			}
		}catch(InterruptedException exception){}
		
	}
	
	
	public void setDone() {
		
	
			done = true;
			
	
		
	}
	
	
}

