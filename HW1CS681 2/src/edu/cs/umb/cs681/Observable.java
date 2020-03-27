package edu.cs.umb.cs681;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Observable {


	  private boolean flag = false;
	  private final LinkedList<Observer> observers;
	
	public  Observable() {
		
		this.observers = new LinkedList<Observer>();

		
		
	} 

	public void addObservers(Observer o) {
	
	
	      this.observers.add(o);

	}
	
	public void deletObserver(Observer o) {
		this.observers.remove(o);
		
	}
	

	
	 protected void setChanged() {
this.flag=true;		
		
		
	}
	
	 public void notifyObservers() {
		 
		 notifyObservers(null);
	 }
	 
	 
	 protected void clearchanged() {
		
		flag = false;
		
	}
	
	public boolean hasChanged() {
		
		return this.flag;}
	
public void notifyObservers(Object arg)	{
	if(hasChanged() == false) 
	{return ;}
	else if(hasChanged()==true) 
	{
		for(int i =0; i < this.observers.size(); i++)
		{
			this.observers.get(i).Update(this,arg);
			
		}
	}
	
	
}
	
public int countObservers() {
	
	return observers.size();
}




	

}
