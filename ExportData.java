import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // Test the countryInfo method
        System.out.println(countryInfo(parser, "Germany"));
        
        // Reset parser and test listExportersTwoProducts method
        parser = fr.getCSVParser(); 
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        // Reset parser and test numberOfExporters method
        parser = fr.getCSVParser(); 
        System.out.println("Number of exporters for gold: " + numberOfExporters(parser, "gold"));
        
        // Reset parser and test bigExporters method
        parser = fr.getCSVParser(); 
        bigExporters(parser, "$999,999,999");
    }
    
    // 2. Find country information
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            // Retrieve the "Country", "Exports", and "Value (dollars)" columns
            String countryName = record.get("Country");
            if (countryName.equals(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return countryName + ": " + exports + ": " + value;
            }
        }
        return "NOT FOUND";
    }

    // 3. List countries that export both exportItem1 and exportItem2
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    // 4. Count the number of countries exporting a specific item
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }

    // 5. List countries with an export value greater than the specified amount
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }
}
