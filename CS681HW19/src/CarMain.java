import java.util.ArrayList;

public class CarMain {

	public static void main(String[] args) {
//price year mileage
		
	//	max min count 
		ArrayList<Car> cars = new ArrayList<Car>();
	     cars.add(new Car(50000,2019,10000,"Prius"));
		cars.add(new Car(2000,1999,1050000,"Boxer"));
		cars.add(new Car(8000,2009,55000,"Forrester"));
		cars.add(new Car(1000,2017,45000,"Camry"));
		cars.add(new Car(3000,2015,30700,"Altima"));
		cars.add(new Car(2500,2001,80000,"Grand Cherokee"));
		cars.add(new Car(2500,2007,90000,"Grand Cherokee"));
		
		
	Integer price = cars.stream()
			.parallel()
			.map((Car car)-> car.getPrice())
			.reduce(0, (result,carprice)->{
				if(result==0) return carprice;
				else if(carprice < result) return carprice;
				else return result;});
				
	int maxmileage = cars.stream()
			.parallel()
			    .map((Car car )-> car.getMileage())
			    .reduce(Integer.MIN_VALUE, (car1 , car2)
			    		-> Integer.max(car1, car2));
	
	

	   int count = cars.stream()
			   .parallel()
			    .map((Car car )-> car.getModel())
			    .distinct()
			    .reduce(0,
			            (Integer accumInt, String intresult) ->
			               ++accumInt, //accumulator
			            (Integer accumInt1, Integer accumInt2) ->
			               accumInt1 + accumInt2);//combiner
	
	
	int min = cars.stream()
			.parallel()
		    . mapToInt((Car car )-> car.getMileage())
		    .reduce(Integer.MAX_VALUE, (car1 , car2)
	        -> Integer.min(car1, car2));
	
	double avgmileage = 
           cars.stream()
			.parallel()
		    .mapToInt((Car car )-> car.getMileage())
		    .average()
		    .getAsDouble();
	

	System.out.print("Max Mileage is:"+ maxmileage+" ");

	System.out.print("Avg Mileage is:"+ avgmileage+" ");
	System.out.print("Min Mileage is:"+ min+ " ");
	System.out.print("Number of distinct models:" + count + "");
	
			}
	
	
}