
public abstract class Entry {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isDirectory();

    public abstract boolean isLocal();

    public abstract String getRepoId();

    public abstract int getEntryId();

    @Override
    public String toString() {
        return "Entry{"
                + "name='" + name + '\''
                + '}';
    }
    public static void main(String[] args) {
        
    }
}
