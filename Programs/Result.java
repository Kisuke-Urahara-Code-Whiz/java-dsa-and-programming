package Programs;

import java.util.List;

public class Result{
    private final List<List<Integer>> shortestPaths;
    private final List<Integer> shortestDistances;

    Result(List<List<Integer>> shortestPaths, List<Integer> shortestDistances){
        this.shortestPaths = shortestPaths;
        this.shortestDistances = shortestDistances;
    }

    public List<List<Integer>> getShortestPaths(){
        return this.shortestPaths;
    }

    public List<Integer> getShortestDistances(){
        return this.shortestDistances;
    }
}
