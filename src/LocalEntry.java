
import java.io.File;



public class LocalEntry extends Entry {
    private final File file;

    public LocalEntry(File file) {
        this.file = file;
        setName(file.getName());
    }

    public File getFile() {
        return file;
    }

    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    @Override
    public boolean isLocal() {
        return true;
    }

    @Override
    public String getRepoId() {
   throw new UnsupportedOperationException("LocalEntry does not support getRepoId() operation.");
    }

    @Override
    public int getEntryId() {
        throw new UnsupportedOperationException("LocalEntry does not support getEntryId() operation.");
    }
}
