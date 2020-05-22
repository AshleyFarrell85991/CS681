import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable {

	
	ReentrantLock lock = new ReentrantLock();


		
		private HashMap<String, Float> map;
		
		public HashMap<String, Float> getMap() {
			
			lock.lock();
			try {
			return map;
		}
			finally {
				
				lock.unlock();
			}
			
		}

		public StockQuoteObservable() {
			map = new HashMap<>();
		}
		
		public void changeQuote(String t,float q) {
			lock.lock();
			try {
			this.map.put(t,q);
			setChanged();
			notifyObservers(new StockEvent(t,q));
		}finally {
			
			lock.unlock();
		}
		
		
		
		
	
} }
