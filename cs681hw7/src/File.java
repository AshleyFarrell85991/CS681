

import java.util.concurrent.locks.ReentrantLock;

public class File {
ReentrantLock lock = new ReentrantLock();

boolean changed = false; 
	public void save() {
		lock.lock();
		try {
	    if(changed== false)	return;
	    else if(changed==true) {
	    	System.out.println("File saved");
	    	changed=false;
	    }
	    
	    
		}finally 
		{
			System.out.println("###");
			lock.unlock();
		}
	}

	public void change() {
  lock.lock();
  try {
	changed = true; 
	
		
	}
  finally {
	  System.out.println("####");
	  lock.unlock();
	  
  }

}
	
}
