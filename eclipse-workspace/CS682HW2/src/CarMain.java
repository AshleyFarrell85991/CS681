import java.util.ArrayList;
import java.util.stream.Stream;

public class CarMain {

	public static void main(String[] args) {
//price year mileage
		
	//	max min count 
		ArrayList<Car> cars = new ArrayList<Car>();
	     cars.add(new Car(50000,2019,10000));
		cars.add(new Car(2000,1999,1050000));
		cars.add(new Car(8000,2009,55000));
		cars.add(new Car(1000,2017,45000));
		cars.add(new Car(3000,2015,30700));
		cars.add(new Car(2500,2001,80000));
		
	Integer price = cars.stream()
			.map((Car car)-> car.getPrice())
			.reduce(0, (result,carprice)->{
				if(result==0) return carprice;
				else if(carprice < result) return carprice;
				else return result;});
				
	int maxmileage = cars.stream()
			    .map((Car car )-> car.getMileage())
			    .reduce(Integer.MIN_VALUE, (car1 , car2)
			    		-> Integer.max(car1, car2));
	
	

   int count = cars.stream()
		    .map((Car car )-> car.getYear())
		    .reduce(0, (result , caryear)
		    		-> {if(caryear > 2001) result++;
		    			return result;});
	
	
	int min = cars.stream()
		    .map((Car car )-> car.getMileage())
		    .reduce(Integer.MAX_VALUE, (car1 , car2)
	        -> Integer.min(car1, car2));

	
	
	
	System.out.print("Max Mileage is:"+ maxmileage+" ");
	System.out.print("Min Mileage is:"+ min+ " ");
	System.out.print("Number of cars newer than 2001:" + count + "");
	
			}
	         
				
		
		
	

}
