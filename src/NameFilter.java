
import java.util.ArrayList;
import java.util.List;

public class NameFilter extends Filter {
    private final String key;

    public NameFilter(String key) {
        this.key = key;
    }

    @Override
    public List<Entry> filter(List<Entry> entries) {
        List<Entry> filteredEntries = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getName().contains(key)) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }
}
