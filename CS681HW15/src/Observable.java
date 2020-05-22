import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class Observable {

private ReentrantLock lock = new ReentrantLock();
AtomicBoolean changed = new AtomicBoolean(false);

	  private final LinkedList<Observer> observers;
	
	public  Observable() {
		
		this.observers = new LinkedList<Observer>();

		
		
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
changed.compareAndSet(false,true);
		
	}
	
	 public void notifyObservers() {
		 

		 
		 notifyObservers(null);
	
	 }
	 
	 
	 protected void clearchanged() {
		 
		 
		 lock.lock();
		 try {
		
		 changed.compareAndSet(true, false);
		
		 }
		 
		 finally {
			 
			 lock.unlock();
		 }
	}
	
	public boolean hasChanged() {
		
		
		lock.lock();
		try {
		
		return this.changed.get();}

		finally {
			
			lock.unlock();
		}
		
	}
public void notifyObservers(Object arg)	{

	lock.lock();
	
	try {
	if(changed.get() == false) 
	{return ;}
	else if(changed.get()==true) 
	{
		for(int i =0; i < this.observers.size(); i++)
		{
			this.observers.get(i).Update(this,arg);
			
		}
	}
	}
	finally {
		
		lock.unlock();
	}
	
	
}
	
public int countObservers() {
	
	
	lock.lock(); try {
	
	return observers.size();
}finally {
	
	lock.unlock();
}
}
	




	

}