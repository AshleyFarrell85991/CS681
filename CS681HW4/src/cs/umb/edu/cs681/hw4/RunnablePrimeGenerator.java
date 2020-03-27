package cs.umb.edu.cs681.hw4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
	
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
	
	    ArrayList<Thread> threads  = new ArrayList<>();
		RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1, 1000000);
		RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(1000000, 2000000);
		Thread t1 = new Thread(gen1);
		Thread t2 = new Thread(gen2);
		threads.add(t1);
		threads.add(t2);
		int threadcount = 0;
		for(Thread t : threads) {
			
			t.start();
			threadcount++;
		}
	//	t1.start();
	//	t2.start();
		for(Thread t : threads ) {
			try {
		t.join();
		} catch (InterruptedException e) {}
		}
		long end = System.currentTimeMillis();
        System.out.print("Threadcount"+ threadcount + "Time:" + (end - start));
        


	}

}

