import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;


public class DIJAQuoteObservable extends Observable {


	
	ReentrantLock lock = new ReentrantLock();

		
		private float quote;
		private Set<Float> data = new HashSet<Float>();
		
		public Set<Float> getData() {
			
			lock.lock();
			try {
			return data;
		}
			finally {
				
				lock.unlock();
				
			}
		}

		public void changeQuote(float q)
		{lock.lock();
		try {
			notifyObservers(new DIJAEvent(q));		
			this.quote = q;
			data.add(q);
			setChanged();
			notifyObservers( new Float(quote));
			
		}finally {
			
			lock.unlock();
		}
		
		}
		

	
	
}
