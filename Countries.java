
import edu.duke.*;
import org.apache.commons.csv.*;

public class Countries
{
    public void listExporters(CSVParser parser, String exportOfInterest, String exportOfInterest2){
     //for each row in the CSV File
         for (CSVRecord rec : parser) {
            //Look at the "Export" column
            String export = rec.get("Exports");
            //Check if it contains exportOfInterest
            if(export.indexOf(exportOfInterest) != -1){
              //If so, write dowm the "Country" from that row
              String country = rec.get("Country");
              System.out.println(country);
            }
    }
}
public void tester(){
    
}
public String countryInfo(CSVParser parser, String country){
    return country;
}
public void listExportersTwoProducts(CSVParser parser, String exportItem1 , String exportItem2){
    System.out.println("The names of the countries that have both items");
    FileResource fr = new FileResource();
    listExporters(parser,"gold","diamonds");
}
}
