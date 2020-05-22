import java.util.concurrent.locks.ReentrantLock;

public class Customer {
	
	private Address address;
	
	ReentrantLock lock = new ReentrantLock();
	
	public Customer(Address address) {
		
		this.address = address;
	}
	
	public Address getAddress() {
		
		lock.lock();
		
		try {
			
			System.out.println(" Retrieving Address as:" + address.toString());
			return address;
		  	
		}
		
		finally {
			
			lock.unlock();
		}
		
	}
	
	
	
	public void setAddress(Address address) {
		
		lock.lock();
		
		try {
			
			this.address = address;
			System.out.print("Setting address as:"+ address.toString());
		}finally {
			
			lock.unlock();
			
		}
		
	}

}
