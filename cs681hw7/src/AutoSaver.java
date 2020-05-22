

import java.util.concurrent.locks.ReentrantLock;

public class AutoSaver implements Runnable {
	  File aFile ;
	    private ReentrantLock lock = new ReentrantLock();
		private boolean done = false; 
		
		
		public AutoSaver(File file) {
			
			this.aFile = file;
		}
		
		
		@Override
		public void run() {
lock.lock();
			try {
		if(done)
			
			System.out.println("Autosaver Executed");
			aFile.save();
			
	
		}finally {
			
			lock.unlock();
		}


		
		
		}
		
		public void setDone() {
			
			done = true;
		}
	}


