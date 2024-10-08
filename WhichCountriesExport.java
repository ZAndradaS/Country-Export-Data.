
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport 
{
    public void listExporters(CSVParser parser, String exportOfInterest){
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
public void whoExportsCoffee(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    listExporters(parser,"coffee");
}
}
