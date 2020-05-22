import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Observable {

private ReentrantLock lock = new ReentrantLock();
private AtomicBoolean changed = new AtomicBoolean(false);
private boolean flag;
	  private final ConcurrentLinkedQueue<Observer> observers;
	
	public  Observable() {
		
		this.observers = new ConcurrentLinkedQueue<Observer>();

		
		
	} 

	public void addObservers(Observer o) {
	
		
		lock.lock();
		try {
	     System.out.print("Adding Observers");
	      this.observers.add(o);

		}
		finally {
			
			lock.unlock();
		}
	}
	
	public void deletObserver(Observer o) {
		
		lock.unlock();
		try {
		this.observers.remove(o);
		}
		
		finally {
			lock.unlock();
			
		}
	}
	

	
	 protected void setChanged() {
		

		
	}
	
	 public void notifyObservers() {
		 

		 
		 notifyObservers(null);
	
	 }
	 
	 
	 protected void clearchanged() {
		 
		 
		 lock.lock();
		 try {
		
		flag = false;
		
		 }
		 
		 finally {
			 
			 lock.unlock();
		 }
	}
	
	public boolean hasChanged() {
		
		
		lock.lock();
		try {
		
		return this.flag;}

		finally {
			
			lock.unlock();
		}
		
	}
public void notifyObservers(Object arg)	{
	lock.lock();
	try {			
		if(!hasChanged()) {
			System.out.println(Thread.currentThread().getId()+ "no change");
			return;	
		}
	}finally {
		lock.unlock();
	}

	
	observers.forEach((Observer ob)
			->{ob.Update(this, arg);} );		
	clearchanged();	
	
	
}
	
public int countObservers() {
	
	
	lock.lock(); try {
	
	return observers.size();
}finally {
	
	lock.unlock();
}
}
public static void main(String[] args) throws InterruptedException {
	
	Observable observable = new Observable();

	ArrayList<Thread> threads = new ArrayList<Thread>();

	for(int i = 0 ; i < 10; i++) {
		 Thread t1 = new Thread(()-> {observable.addObservers((Observable o, Object obj)->{System.out.println("Observer "+obj);});});
		threads.add(t1);
		t1.start();
	
		
	}

	for(Thread t : threads) {
		 
	       t.join();
		
	}
	observable.setChanged();

	
}
}

	




	