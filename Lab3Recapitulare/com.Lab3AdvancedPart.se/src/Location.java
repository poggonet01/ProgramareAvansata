import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    private String name;
    private LocalTime openingTime, closingTime;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    public Location(String name, Map<Location, Integer> cost) {
        this.name = name;
        this.cost = cost;
    }


    public void setCost(Location node , int value) {
        cost.put(node,value);
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }

    public static int compareByOpeningHour(Location a , Location b) {
        return b.compareTo(a);
    }

    @Override
    public String toString() {
        return this.name ;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
