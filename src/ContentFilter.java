
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ContentFilter extends Filter {
    
     private String key;

    public ContentFilter(String key) {
        this.key = key;
    }

     @Override
    public List<Entry> filter(List<Entry> entries) {
        List<Entry> result = new ArrayList<Entry>();
        for (Entry entry : entries) {
            if (entry instanceof FileEntry) {
                FileEntry fileEntry = (FileEntry) entry;
                File file = fileEntry.getFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(key)) {
                            result.add(fileEntry);
                            break;
                        }
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getAbsolutePath());
                }
            }
        }
        return result;
    }
}
