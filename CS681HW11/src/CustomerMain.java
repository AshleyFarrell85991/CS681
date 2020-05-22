
public class CustomerMain  {

	
	
	
	public static void main(String[] args) {
        
      
		
		Address address = new Address("hanover street","boston","ma",02125);
		Customer cust = new Customer(address);
	
		 Thread t1 = new Thread(()->{
			 Address newAddress = new Address(Thread.currentThread().getName(),"NewYork","NY",10010);				
			 cust.getAddress().toString();
			 cust.setAddress(newAddress);			
			 cust.setAddress(cust.getAddress().change("NewStreet", "NewCity",Thread.currentThread().getName(),02124));							 
		 });
		
		t1.start();
		try {
			
			t1.join();
		}catch (Exception ex) {
			
			
		}
	
		
		 Thread t2 = new Thread(()->{
			 Address newAddress = new Address(Thread.currentThread().getName(),"Montauk","NY",11787);				
			 cust.getAddress().toString();
			 cust.setAddress(newAddress);		
			 cust.setAddress(cust.getAddress().change("Streetisnew", "Belgium",Thread.currentThread().getName(),12345));							 
		 });
		
		t2.start();
		
		try {
			
			t2.join();
		}catch (Exception ex ) {
			
			
		}
		
		
		
		
		
		
		
	}

}
