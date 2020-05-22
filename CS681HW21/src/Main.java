import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

		public static void main(String[] args) {
					
			

	        ExecutorService executor = Executors.newFixedThreadPool(10);
	        for (int i = 0; i < 10; i++) {
	    		RequestHandler rq = new RequestHandler();
				Thread t = new Thread(rq);
	            executor.execute(rq);
	          }
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");

}
		
}
