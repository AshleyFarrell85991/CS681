import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable{
	private ThreadSafeBankAccount2 account;
	private volatile boolean done = false;
	ReentrantLock lock = new ReentrantLock();
	public DepositRunnable(ThreadSafeBankAccount2 account) {
		this.account = account;
	}
	
	public void run(){
		lock.lock();
		while(true)
		{
			if(done) {
				break;
			
		}
		try{
			for(int i = 0; i < 10; i++){
				account.deposit(100);
				Thread.sleep(2);
			}
			
		}
		
		catch(InterruptedException exception){}

		finally {
			lock.unlock();
		}
		
		}
		
	
		
}
	
	
	
	

	public void setDone() {
	
			done = true;
			
		}
		
	
	
}
