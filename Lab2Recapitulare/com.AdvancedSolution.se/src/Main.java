public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();

        Source s1 = new Factory("s1");
        Source s2 = new Warehouse("s2");
        Source s3 = new Warehouse("s3");

        Destination d1 = new Destination("d1");
        Destination d2 = new Destination("d2");
        Destination d3 = new Destination("d3");

        Destination[] destinations = {d1,d2,d3};
        Source[] sources = {s1,s2,s3};

        pb.setSources(sources);
        pb.setDestinations(destinations);
        pb.setSuply(new int[]{10,35,25});
        pb.setDemand(new int[]{20,25,25});
        int arr [][] = new int[][]{{2,3,1},{5,4,8},{5,6,8}};
        pb.setCost(arr);

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(pb);
        greedyAlgorithm.solve();
    }
}
