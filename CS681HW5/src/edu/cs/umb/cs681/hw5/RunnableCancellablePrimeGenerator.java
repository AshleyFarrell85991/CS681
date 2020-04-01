package edu.cs.umb.cs681.hw5;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator{

	private ReentrantLock lock = new ReentrantLock(); 
	private boolean done = false;
	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
		
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

	
	public void generatePrimes() {
		
		for(long n = from; n <= to ; n++) {
			lock.lock();
			try {
				if(isPrime(n)) {this.primes.add(n); } } 
				finally {
					lock.unlock(); }
				}
			
		
	}
	
	public void run() {
		
		generatePrimes();
	}
	
	
}
