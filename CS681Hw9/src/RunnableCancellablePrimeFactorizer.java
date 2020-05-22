import java.util.concurrent.locks.ReentrantLock;


public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {
	



	private ReentrantLock lock = new ReentrantLock(); 
	private boolean done = false;
	protected long from;
	protected long to; 
	protected long dividend;
	

	
	public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, to,from);
		
	}



	

	public void generatePrimeFactors() {
	
		long divisor = from;
		
	    while( dividend != 1 && divisor <= to ){
	    	lock.lock();
	    	
			try {
				if(done) {
	    	System.out.println("Stop generating prime factors");
				this.factors.clear();
	    	} if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
			
		    	
		    }
		}
		finally {
			lock.unlock();
			
		}
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
	}
	    
	}
	    
	}

	
			
	
	
	
	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer gen =
				new RunnableCancellableInterruptiblePrimeFactorizer(2,100,100);
		Thread thread = new Thread(gen);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gen.setDone();
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gen.getPrimeFactors().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimeFactors().size() + " prime numbers are found.");
	}

}

