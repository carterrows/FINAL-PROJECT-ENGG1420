
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class LengthFilter extends Filter {

    private List<File> entries;
    private long length;
    private String operator;

    public LengthFilter(List<File> entries, long length, String operator) {
        this.entries = entries;
        this.length = length;
        this.operator = operator;
    }

    public List<File> filter() {
        List<File> result = new ArrayList<File>();
        for (File entry : entries) {
            if (entry.isFile()) {
                long entryLength = entry.length();
                boolean includeEntry = false;

                switch (operator) {
                    case "EQ":
                        includeEntry = (entryLength == length);
                        break;
                    case "NEQ":
                        includeEntry = (entryLength != length);
                        break;
                    case "GT":
                        includeEntry = (entryLength > length);
                        break;
                    case "GTE":
                        includeEntry = (entryLength >= length);
                        break;
                    case "LT":
                        includeEntry = (entryLength < length);
                        break;
                    case "LTE":
                        includeEntry = (entryLength <= length);
                        break;
                    default:
                        System.out.println("Invalid operator: " + operator);
                        break;
                }

                if (includeEntry) {
                    result.add(entry);
                }
            }
        }
        return result;
    }
}
