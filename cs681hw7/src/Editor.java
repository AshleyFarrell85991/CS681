import java.util.concurrent.locks.ReentrantLock;


public class Editor implements Runnable {

    File aFile;
    private ReentrantLock lock = new ReentrantLock();
	private boolean done = false; 
	
	public Editor(File file) {
		this.aFile = file;
		
	}
	
	
	@Override
	public void run() {
		
		lock.lock();
		try {
	if(done)
	{
		System.out.println("Edtior running");
		}
		
		aFile.change();
		aFile.save();
	try {
		Thread.sleep(1000);
		
	}catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		
		}finally {
	    System.out.println("Editor is finished");
		lock.unlock();
	}


	
	
	}
	
	public void setDone() {
		
		done = true;
	}

}