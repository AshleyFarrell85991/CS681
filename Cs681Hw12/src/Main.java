import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class Main {

	public static void main(String[] args) {
		RequestHandler rq = new RequestHandler();
		
		ArrayList<Thread> threads = new ArrayList<>();
		for(int i = 0 ; i < 11; i++) {
			
			Thread t = new Thread(rq);
			threads.add(t);
			t.start();

		}
		
		for(int i = 0; i < 11 ; i++) {
			
			threads.get(i).interrupt();
		}
		
		rq.Setdone();
		
		
     for(int i = 0 ; i < 11 ; i++) {
    	 
try {
	
	threads.get(i).join();
}catch(InterruptedException e) {
	
}

     }
		
		
	}

}
