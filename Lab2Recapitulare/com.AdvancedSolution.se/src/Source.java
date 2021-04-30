import java.util.SortedMap;

public abstract class Source {
    protected String name;

    public Source(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)){
            return false;
        }
        Source other = (Source) obj;
        return this.name.equals(other.name);
    }
}
