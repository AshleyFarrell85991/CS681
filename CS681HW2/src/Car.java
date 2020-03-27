
public class Car {

	private int price;
	private int year;
	private int mileage;
private int DominationCount;

	
	public Car(int price, int year, int mileage)
	{
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice() {
		
		this.price= price;
	}

	public int getYear()
	{
		return year;
	}
	public int getMileage()
	{
		return mileage;
	}
	public void setDominationCount(int DominationCount) {
this.DominationCount  = DominationCount;		
	}
	
	public int getDominationCount() {
		return DominationCount;
	}
	

	
	
}
