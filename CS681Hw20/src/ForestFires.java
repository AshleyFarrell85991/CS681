
public class ForestFires {

	private String month; 
	private String day;
	private int FFMC; 
	private int temp;

	private int rain;
	
	public  ForestFires(String month, String day , int FFMC , int temp, int rain) {
		this.month = month; 
		this.day = day; 
		
		//moisture ranking when subtracted from 100 
		this.FFMC = FFMC;
		// temperature in Celsius degrees: 2.2 to 33.30 
		this.temp = temp; 
		//rain - outside rain in mm/m2 : 0.0 to 6.4 
		this.rain = rain;
		
		
		
	}
	
	public void setMonth(String month) {
		this.month = month;
		
	}
	
	public String getMonth() {
		return month;
		
	}
	
	public void setday(String day) {
		this.day = day;
		
	}
	
	public String getday() {
		
		return day;
		
	}
	
	
	public void setFFMC() {
		this.FFMC= FFMC;
		
	}
	
	public int getFFMC() {
		return FFMC;
		
	}
	
	public void setTemp() {
		
		this.temp = temp;
	}
	
	public int getTemp() {
		
		return temp;
	}
	
	public void setRain() {
	this.rain = rain;	
	}
	
	public int getRain() {
		
		return rain; 
	}
	

}
