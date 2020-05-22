import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {
private int currentVisitors = 0; 
private volatile boolean done = false;


private ReentrantLock lock;
private Condition conditionaladmission;
private AdmissionControl control;
 public AdmissionControl()
 {
	 lock = new ReentrantLock();
	 conditionaladmission = lock.newCondition();
	 currentVisitors = 0;
	 control = this;
 }
 
 public void resetDone() {
	 done = false; //
 }
 public void setDone() {
		done = true; 
	}


public void enter() {
	lock.lock();
	try {
	while(currentVisitors >= 5){
		System.out.print("Too many visitors. Please wait for a while!");
		
		conditionaladmission.await();
	}
	currentVisitors ++;

	System.out.println(
			"Visitors: " + currentVisitors);
}
catch (InterruptedException exception){
	exception.printStackTrace();
}
finally{
	lock.unlock();
	System.out.print("Thread Executed!");

}		

	
}

public void exit() {
	
	lock.lock();	
	try{
			
		currentVisitors --;
		System.out.println(
				"Visitors: " + currentVisitors);
		conditionaladmission.signalAll();
	}		
	finally{
		lock.unlock();
		System.out.print("Thread Executed!");	}
}


public int countCurrentVisitors(){
	
	lock.lock(); 
	try {
		System.out.print("Current Visitor Count:"+ currentVisitors);
		return currentVisitors; 
		
	}finally
	{
		
		lock.unlock();
	}
	
 }


class MonitorHandler implements Runnable

{ 
public void run(){
	

control.countCurrentVisitors();}}

public class EntranceHandler implements Runnable {

	@Override
	public void run() {
		
		while(!done) { 
			
			control.enter();	
		}

	
	}
	
	
	
}


public class ExitHandler implements Runnable {

	@Override
	public void run() {
		
		
		while(!done) {
control.exit()	;	
	}
	}
	
}
	
	
}
