import java.util.LinkedList;

public class ConcurrentPrimeFactorizer {
	private LinkedList<Long> factors = new LinkedList<Long>();
	private LinkedList<RunnablePrimeFactorizer> runnables = new LinkedList<RunnablePrimeFactorizer>();
	private LinkedList<Thread> threads = new LinkedList<Thread>();

	public ConcurrentPrimeFactorizer(long dividend, int nThreads) {
		System.out.println("The number to be factorized: " + dividend);
		long upperLimit; 	// Upper limit for the range of divisors
		long dividedRange;	// Range of divisors that each thread works on
		
		// Decrease nThreads if it is too many to factorize dividend. 
		while (true) {
			upperLimit = (long) Math.sqrt(dividend) + 1;
			dividedRange = upperLimit / nThreads;
			if (dividedRange > 2) {
				break;
			} else {
				nThreads--;
			}
		}
		System.out.println("The number of threads: " + nThreads);
		
		RunnablePrimeFactorizer runnable;
		Thread thread;
		long fromLocal = 2;
		long toLocal = dividedRange;
		for (int i = 0; i < nThreads; i++) {
			runnable = new RunnablePrimeFactorizer(dividend, fromLocal, toLocal);
			runnables.add(runnable);
			fromLocal = toLocal + 1;
			toLocal = fromLocal + dividedRange;
			if(i == nThreads-2) {toLocal = upperLimit;}

			thread = new Thread(runnable);
			threads.add(thread);
			System.out.println("Thread ID: " + thread.getId() + 
								", Range of divisors: " + runnable.getFrom() + "->" + runnable.getTo());
		}
	}

	public ConcurrentPrimeFactorizer(long dividend) {
		this(dividend, Runtime.getRuntime().availableProcessors());
	}

	public LinkedList<Long> getPrimeFactors() {
		threads.forEach((thread) -> thread.start());
		threads.forEach((thread) -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		runnables.forEach((runnable) -> factors.addAll(runnable.getPrimeFactors()));
		return factors;
	}

	
	

	public static void main(String[] args) {
		ConcurrentPrimeFactorizer fac = new ConcurrentPrimeFactorizer(36, 2);
		System.out.println("Final result: " + fac.getPrimeFactors());

		fac = new ConcurrentPrimeFactorizer(84, 4);
		System.out.println("Final result: " + fac.getPrimeFactors());

//		System.out.println(Runtime.getRuntime().availableProcessors());
		fac = new ConcurrentPrimeFactorizer(125);
		System.out.println("Final result: " + fac.getPrimeFactors());

		fac = new ConcurrentPrimeFactorizer(2489);
		System.out.println("Final result: " + fac.getPrimeFactors());
		
		fac = new ConcurrentPrimeFactorizer(8633);
		System.out.println("Final result: " + fac.getPrimeFactors());
	}

}

