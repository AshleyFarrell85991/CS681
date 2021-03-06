

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVReader {
	static String csvFile = "./Untitled spreadsheet - Sheet1.csv";
    public static void main(String[] args) {
    	
  ArrayList<ForestFires>fires = readFromCSV(csvFile);


	int lotemp = fires.stream()
			.map((ForestFires fire)-> fire.getTemp())
			.reduce(0, (result,temps)->{
				if(result==0) return temps;
				else if(temps < result) return (temps);
				else return( result);});
				

System.out.println("Lowest Temp in C:"+ lotemp);



int maxtemp = fires.stream()
		    .map((ForestFires fire )-> fire.getTemp())
		    .reduce(Integer.MIN_VALUE, (fire1 , fire2)
		    		-> Integer.max(fire1, fire2));



System.out.println("Highest Temp in C:"+ maxtemp);


int [] avgtemp = fires.stream()
		    .map((ForestFires fire )-> fire.getTemp())
		    .reduce(new int[3],(arr,temp)
            ->{arr[0] = 1+arr[0];
            arr[1]=temp + arr[1];
            if(arr[0]!=0)
            	arr[2] = arr[1]/arr[0];
            return arr;
            },(arr,intavg)->{return arr;});

System.out.println("Number of fires:"+ " " +avgtemp[0]+ " "+ "Average Temp in C:"+" "+ avgtemp[2]);



    
    }
    
    private static ArrayList<ForestFires> readFromCSV(String fileName) {
    	ArrayList<ForestFires> ff = new ArrayList<>(); Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { // read the first line from the text file String line = br.readLine(); // loop until all lines are read while (line != null) { // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter String[] attributes = line.split(","); Book book = createBook(attributes); // adding book into ArrayList books.add(book); // read next line before looping // if end of file reached, line would be null line = br.readLine(); } } catch (IOException ioe) { ioe.printStackTrace(); } return books; }

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
    	try {
            
    		  

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fires = line.split(cvsSplitBy);
                ForestFires f = createFF(fires);
                ff.add(f);

               
 
        }
    	

}catch(IOException io) { 
    	
    } return ff; } 
    	
    	private static ForestFires createFF(String[]metadata) {
    		   String month = metadata[0];
               String day = metadata[1];
               Integer FFMC = Integer.parseInt(metadata[2]);
               Integer temp = Integer.parseInt(metadata[3]);
               Integer rain = Integer.parseInt(metadata[4]);
               
               return new ForestFires(month,day,FFMC,temp,rain);
    	}
}
    
    
    
    
    


