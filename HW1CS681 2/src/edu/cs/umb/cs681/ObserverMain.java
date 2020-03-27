package edu.cs.umb.cs681;

public class ObserverMain {

	public static void main(String[] args) {

		StockQuoteObservable observable = new StockQuoteObservable();
		observable.addObservers(( Observable obs , Object obj)->
		{System.out.println(obj);
		});
		
	
       observable.setChanged();
       observable.notifyObservers(" Stock Quote changed");
	

DIJAQuoteObservable dijobserv = new DIJAQuoteObservable();
//	 
dijobserv.addObservers(( Observable obs1 , Object obj1)->
{System.out.println(obj1);
	});
//	
//
	dijobserv.setChanged();
	dijobserv.notifyObservers(" dija changed");
	
	
	
	
	}
	
	
	
}
