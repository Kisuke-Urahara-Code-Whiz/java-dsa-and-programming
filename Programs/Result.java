package Programs;

import java.util.List;

public class Result{
    private final int[] predecessors;
    private final int[] shortestPathCounts;
    private final List<Integer> shortestDistances;

    Result(int[] predecessors, int[] shortestPathCounts, List<Integer> shortestDistances){
        this.predecessors = predecessors;
        this.shortestPathCounts = shortestPathCounts;
        this.shortestDistances = shortestDistances;
    }

    public int[] getPredecessors(){
        return this.predecessors;
    }

    public List<Integer> getShortestDistances(){
        return this.shortestDistances;
    }

    public int[] getShortestPathCounts(){
        return this.shortestPathCounts;
    }
}
