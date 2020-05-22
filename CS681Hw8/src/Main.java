
public class Main {

	public static void main(String[] args) {

	 Thread cs1 = new Thread(new ConcurrentSingleton());
	 
	 Thread cs2 = new Thread(new ConcurrentSingleton());
	 Thread cs3 = new Thread(new ConcurrentSingleton());
	 Thread cs4 = new Thread(new ConcurrentSingleton());
	 
	 cs1.start();
	 cs2.start();
	 cs3.start();
	 cs4.start();

	 try {
		  cs1.join();
		  cs2.join();
		  cs3.join();
		  cs4.join();
	 }catch(InterruptedException e) {
		 e.printStackTrace();
	 }
	  
	  

	}

}
