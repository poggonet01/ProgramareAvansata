public class Problem {
    private Source[] sources;
    private Destination[] destinations;

    private int[] suply;
    private int[] demand;
    private int[][] cost;

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[] getSuply() {
        return suply;
    }

    public void setSuply(int[] suply) {
        this.suply = suply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

}
