public class GreedyAlgorithm {
    private Problem pb;

    public GreedyAlgorithm(Problem pb) {
        this.pb = pb;
    }

    public void solve () {
        int dim = pb.getDemand().length;
        int [][] cost = pb.getCost();
        int [] suply = pb.getSuply();
        int [] demand = pb.getDemand();
        int TotalCost = 0;
        while (true) {
            for (int i = 0; i < dim; i++) {
                int min = 99999;
                int poz = 0;
                for (int j = 0; j < dim ; j++) {
                    if (cost[i][j] < min && demand[j] != 0) {
                        min = cost[i][j];
                        poz = j;
                    }
                }
                if (demand[poz] != 0 && suply[i] != 0 && suply[i] < demand[poz] ) {
                    TotalCost += suply[i] * min;
                    demand[poz] = demand[poz] - suply[i];
                    suply[i] = 0;
                }
                else if (suply[i] != 0 && demand[poz] != 0 ) {
                    TotalCost += min * demand[poz];
                    suply[i] = suply[i] - demand[poz];
                    demand[poz] = 0;
                }
            }
            int ok = 0;
            for (int i = 0; i < dim; i++) {
                if (demand[i] != 0) {
                    ok = 1;
                    break;
                }
            }
            if (ok == 0)
                break;

        }
        System.out.println(TotalCost);
    }
}
