package Programs;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    private class Result{
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

    private Result algorithm(int[][] edges, int n, int src){
        List<List<Integer>> shortestPaths = new ArrayList<>();
        List<Integer> shortestDistances = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> path = new ArrayList<>();
            shortestPaths.add(path);
            path.add(src);
            if(i==src) shortestDistances.set(i,0);
            else shortestDistances.set(i,null);
        }
        for(int i=0;i<edges.length;i++){
            
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {6, 7, 2},
                {0, 1, 6},
                {2, 3, 1},
                {1, 2, 5},
                {4, 6, 1},
                {0, 2, 7},
                {1, 4, -4},
                {3, 1, -2},
                {2, 4, 8},
                {4, 5, -2},
                {5, 6, 3},
                {3, 5, 6},
                {7, 5, 4},
                {1, 3, -3},
                {8, 9, 10},
                {0, 8, 5},
                {9, 6, -1},
                {4, 8, 2},
                {10, 11, -5},
                {5, 10, 7}
        };
        int n = 12;
        Result result = algorithm(edges, n, 0);
    }

}
