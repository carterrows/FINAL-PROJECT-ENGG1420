import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListProcessingElement {
    
    private int max;
    
    public ListProcessingElement(int max) {
        this.max = max;
    }
    
    public List<File> process(JSONArray) {
        for (int i = 0; i < 10; i++) {
            
        }
        
        
        List<File> output = new ArrayList<>();
        for (File entry : entries) {
            if (entry.isDirectory()) {
                File[] innerEntries = entry.listFiles();
                if (innerEntries.length <= this.max) {
                    output.addAll(Arrays.asList(innerEntries));
                } else {
        output.addAll(Arrays.asList(Arrays.copyOfRange(innerEntries, 0, this.max)));
                }
            }
        }
        return output;
    }
}

