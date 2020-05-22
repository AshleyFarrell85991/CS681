import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{

	ConcurrentSingleton() {} ;

private Singleton singletonInstance;

	
	private static ReentrantLock lock = new ReentrantLock();
	


	@Override
	public void run() {

		singletonInstance = Singleton.getInstance();

		System.out.println(singletonInstance);
	}
	
}
