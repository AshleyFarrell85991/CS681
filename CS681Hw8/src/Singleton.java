import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

	
	private static ReentrantLock lock = new ReentrantLock();
	private Singleton() {
		
	};
	
	private static Singleton instance = null;
	public static Singleton getInstance() {
		
		lock.lock(); 
		try {
			if(instance==null) {
				
				instance = new Singleton(); 
			}
			return instance;
			
		}finally {
			System.out.println("####");
			lock.unlock();

		}
		
		
	}
	
	
}
