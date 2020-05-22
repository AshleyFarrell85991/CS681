import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {
	ReentrantLock lock = new ReentrantLock();
	boolean done = false;
File folder = new File("./data");
File[] listofFiles = folder.listFiles();

	//Path[] arr = {Paths.get("\\.txt")};;




	  AccessCounter ac = AccessCounter.getInstance();
		@Override
		public void run() {
	         while(true) {
			lock.lock();
			try {
				if(done) {
				break;
				}
				
                Path path = getRandom(listofFiles).toPath();
                ac.increment(path);
				System.out.println(path.getFileName()+ ",AccessCount:" +ac.getCount(path));
				
			}
			finally 
			{
				lock.unlock();
				Setdone();
			}
			
			try {
				
				Thread.sleep(10000);
			}
			catch(InterruptedException e) {
				
				continue;
			}
			
	         }
		}
		
		
		public static File getRandom(File[] array) {
		    int rnd = new Random().nextInt(array.length);
		    return array[rnd];
		}
		
		
		public void Setdone() {
			
			lock.lock();
			
			try {
				done = true;
				
			}
			
			finally {
				lock.unlock();
			}
		}
	
			 
			  }
