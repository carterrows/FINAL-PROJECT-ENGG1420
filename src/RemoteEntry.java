
public class RemoteEntry extends Entry {
 private final String repoId;
 private final int entryId;

    public RemoteEntry(String repoId, int entryId, String name) {
        this.repoId = repoId;
        this.entryId = entryId;
        setName(name);
    }

    public String getRepoId() {
        return repoId;
    }

    public int getEntryId() {
        return entryId;
    }

    @Override
    public boolean isDirectory() {
 throw new UnsupportedOperationException("RemoteEntry does not support isDirectory() operation.");
    }

    @Override
    public boolean isLocal() {
        return false;
    }
}

    

