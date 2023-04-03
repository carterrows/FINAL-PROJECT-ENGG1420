import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitProcessingElement {
    
    private int lines;
    
    public SplitProcessingElement(int lines) {
        this.lines = lines;
    }
    
    public List<File> process(List<File> entries) throws IOException {
        List<File> output = new ArrayList<>();
        for (File entry : entries) {
            if (entry.isFile()) {
                String name = entry.getName();
                String[] nameParts = name.split("\\.");
                String baseName = nameParts[0];
                String extension = nameParts[1];
                BufferedReader reader = new BufferedReader(new FileReader(entry));
                String line = reader.readLine();
                int partNumber = 1;
                while (line != null) {
                    List<String> lines = new ArrayList<>();
                    for (int i = 0; i < this.lines && line != null; i++) {
                        lines.add(line);
                        line = reader.readLine();
                    }
        File outputFile = new File(entry.getParent(), baseName + ".part" + partNumber + "." + extension);
                    FileWriter writer = new FileWriter(outputFile);
                    for (String l : lines) {
                        writer.write(l + "\n");
                    }
                    writer.close();
                    output.add(outputFile);
                    partNumber++;
                }
                reader.close();
            }
        }
        return output;
    }
}
