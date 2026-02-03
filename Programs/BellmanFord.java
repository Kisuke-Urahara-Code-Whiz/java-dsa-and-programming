package Programs;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    private Result algorithm(int[][] edges, int n, int src){
        List<List<Integer>> shortestPaths = new ArrayList<>();
        List<Integer> shortestDistances = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> path = new ArrayList<>();
            shortestPaths.add(path);
            path.add(src);
            if(i==src) shortestDistances.add(0);
            else shortestDistances.add(null);
        }
        for(int i=0;i<n-1;i++){
            for(int[] j: edges){
                if(shortestDistances.get(j[0])!=null){
                    int cost = shortestDistances.get(j[0])+j[2];
                    Integer prevShortestDistance = shortestDistances.get(j[1]);
                    if(prevShortestDistance==null || cost<prevShortestDistance){
                        shortestDistances.set(j[1], cost);
                        List<Integer> path = shortestPaths.get(j[0]);
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(j[1]);
                        shortestPaths.set(j[1], newPath);
                    } else if(cost==prevShortestDistance){
                        List<Integer> path = shortestPaths.get(j[0]);
                        if(path.size()+1<shortestPaths.get(j[1]).size()){
                            List<Integer> newPath = new ArrayList<>(path);
                            newPath.add(j[1]);
                            shortestPaths.set(j[1], newPath);
                        }
                    }
                }
            }
        }
        Result result = new Result(shortestPaths, shortestDistances);
        return result;
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
                {3, 1, 5},
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
        int src = 0;
        Result result = new BellmanFord().algorithm(edges, n, src);
        List<Integer> shortestDistances = result.getShortestDistances();
        List<List<Integer>> shortestPaths = result.getShortestPaths();
        for(int i=0;i<n;i++){
            System.out.println(src+" -> "+i+" , Shortest Distance -> "+shortestDistances.get(i)+" , Path -> "+shortestPaths.get(i));
        }
    }

}
