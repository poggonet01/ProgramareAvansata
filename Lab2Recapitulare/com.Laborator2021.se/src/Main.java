import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();
        Source s1 = new Source("s1" , SourceType.FACTORY);
        Source s2 = new Source("s2" , SourceType.WAREHOUSE);
        Source s3 = new Source("s3" , SourceType.WAREHOUSE);

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


        for (int i = 0 ; i < sources.length; i++) {
            int supply = pb.getSuply()[i];
            System.out.println(sources[i] + " Suply: " + supply);
        }

        for (int i = 0 ; i < destinations.length; i++) {
            int demand = pb.getDemand()[i];
            System.out.println(destinations[i] + " Demand: " + demand);
        }



    }
}
