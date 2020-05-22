import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		AdmissionControl ac = new AdmissionControl();		
	
		
		ArrayList<Thread> threads = new ArrayList<Thread>(5);
		 for (int i = 0; i <4 ; i++) 
		 {
			 Thread t1 = new Thread(ac.new EntranceHandler());
			 threads.add(t1);
			 t1.start();
			 
		 }
		 
			 Thread tm = new Thread(ac.new MonitorHandler());
			 threads.add(tm);
			 tm.start();
			 try {
						Thread.sleep(10);
					} catch (InterruptedException e) {			
						e.printStackTrace();
					}
			 
		
		 for (int i = 0; i <3 ; i++) 
		 {
			 Thread te = new Thread(ac.new ExitHandler());
			 threads.add(te);
			 te.start();
			 
		 }
				 try {
						Thread.sleep(10);
					} catch (InterruptedException e) {			
						e.printStackTrace();
					}	
		 for (int i = 0; i < 5; i++) 
		 {
			
			 threads.get(i).interrupt();
		 }
		 
		 				ac.setDone();
		 				
		 for (int i = 0; i < 5; i++) 
		 {
			 try {								
					 threads.get(i).join();
				 }
			catch (Exception e) {
				System.out.println(e);
			}
		}
		

		ac.resetDone();
		Thread tm1 = new Thread(ac.new MonitorHandler());		
		 tm1.start();
		 try {
			Thread.sleep(1);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		 
		ac.setDone();
		
			
	}
}
