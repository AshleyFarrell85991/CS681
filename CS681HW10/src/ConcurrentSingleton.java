import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class ConcurrentSingleton  implements Runnable{



	private static AtomicReference<ConcurrentSingleton>
	instance = new AtomicReference<>(null);
	ConcurrentSingleton() {} ;
	
	public static synchronized ConcurrentSingleton getInstance() {
		ConcurrentSingleton cs = instance.get();
		if(instance ==null) {
			synchronized(ConcurrentSingleton.class) {
				cs = instance.get();
				if(cs ==null) {
					cs = new ConcurrentSingleton();
					boolean changed = instance.compareAndSet(null, cs);
					assert changed;
				}
			}
		
	
	
	}
		return cs;
	
}
	
	
	public static void setInstance(ConcurrentSingleton to) {
		
		instance.set(to);
	}

	@Override
	public void run() {
        ConcurrentSingleton.getInstance();		

	}


	
	
	public static void main(String[] args) {
        
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<10;i++)
		{
			Thread t =new Thread(new ConcurrentSingleton());
			t.start();
		}
		threads.forEach((Thread t)->{try {
			t.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}
		
	}
	
	
	
