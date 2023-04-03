
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Scenario {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("enter the file procesing scenario file's name: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        try {
            JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader(filename));
            JSONArray processingElement=(JSONArray) obj.get("processing_elements");
            for (int i = 0; i < processingElement.size(); i++) {
                JSONObject obj1 = (JSONObject) processingElement.get(i);
                switch ((String) obj1.get("type")) {
                    case "List": 
                        int max = 0;
                        JSONArray processingElementsArray = (JSONArray)obj1.get("parameters");
                        for (int j = 0; j < processingElementsArray.size(); j++) {
                            JSONObject arrayObj = (JSONObject)processingElementsArray.get(j);
                            if ( ((String)arrayObj.get("name")).equals("Max") ) {
                                max = (int)arrayObj.get("value");
                                
                            }
                        }
                        if (max>0) {
                            ListProcessingElement listObj = new ListProcessingElement(max);
                            
                        }
                        else {
                            System.out.println("max is zero or less");
                        }
                        
                        break;
                    default:
                        ;
                }
           }
        } catch (ParseException ex) {
            System.out.println("File cannot be parsed by json");
            //Logger.getLogger(Scenario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            System.out.println("File cannot be opened");
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        
        
    }

}
