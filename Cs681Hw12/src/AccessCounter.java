import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	static AccessCounter instance = null;
	int counter;
	 ReentrantLock lock = new ReentrantLock();
	static  ReentrantLock slock = new ReentrantLock();

	HashMap<Path,Integer> map = new HashMap();
	
	private  AccessCounter(){}
	
	
	public static AccessCounter getInstance() {
		
		slock.lock();
		
		try {
			if(instance==null)
			{
				System.out.println("Creating AccessCounter");
				instance = new AccessCounter(); }
			}finally {
				slock.unlock();
			}
		
		return instance;
			
			
		
	}
	
	public void increment(Path path) {

			lock.lock();
		try {
			map.putIfAbsent(path, 1);
			map.put(path, map.get(path)+1);
          
			
		}finally {
			
			lock.unlock();
		}
		
		
	}
	
	
	
	int getCount(Path path) {
		

			
			lock.lock(); 
			try {
			if(map.containsKey(path)) {

			return	map.get(path);
				
			}
			else 
				return 0;
			
			
		}finally {
			
			lock.unlock();
		}
		
		
	}
	
	

	
	
	
	
}
