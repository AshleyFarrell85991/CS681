import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
@SuppressWarnings("unchecked")

public class AccessCounter {
	static AccessCounter instance = null;
	int counter;
	 ReentrantLock lock = new ReentrantLock();
	static  ReentrantLock slock = new ReentrantLock();

	ConcurrentHashMap<Path,AtomicInteger> map = new ConcurrentHashMap();
	
	private  AccessCounter(){}
	
	
	public static AccessCounter getInstance() {
		
			if(instance==null)
			{
				System.out.println("Creating AccessCounter");
				instance = new AccessCounter(); }
			
		
		return instance;
			
			
		
	}
	
	public void increment(Path path) {

		
			map.putIfAbsent(path, new AtomicInteger());
			map.get(path).incrementAndGet();
          
			
		
		
		
	}
	
	
	
	AtomicInteger getCount(Path path) {
		

			
		
			if(map.containsKey(path)) {

			return	map.get(path);
				
			}
			else 
				return new AtomicInteger(0);
			
			
		
		
		
	}
	
}
