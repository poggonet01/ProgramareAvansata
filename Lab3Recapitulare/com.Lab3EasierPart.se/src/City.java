import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Location> nodes = new ArrayList<>();

    public void addLocation(Location node){
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }
}
