import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {
	
	



	private ReentrantLock lock = new ReentrantLock(); 
	private boolean done = false;
	private long from;
	private long to; 
	private long dividend;
	

	
	public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend,from,to);
	
		
	}



	public void setDone() {
		lock.lock();
		try {
		done = true;
		}
		
		finally {
			lock.unlock();
			
		}
	}

	
	
	
	
	
	


		public void generatePrimeFactors() {
			long divisor = from;

			while(true) {
		
			try {
				lock.lock();
				if(done) {
					break;}
						
					else {

		    while( dividend != 1 && divisor <= to ){
		    	if( divisor > 2 && isEven(divisor)) {
		    		divisor++;
		    		continue;
		    	}
			    if(dividend % divisor == 0) {
			        factors.add(divisor);
			        dividend /= divisor;
			    }else {
			    	if(divisor==2){ divisor++; }
			    	else{ divisor += 2; }
			    	
			    }
			    
		    }
			}
				
			
				
			}finally {
				
				lock.unlock();
			}
	
	}}

	
			
	
	
	
public static void main(String[] args) {

}
	
}
