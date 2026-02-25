package Programs;

import java.util.ArrayList;
import java.util.List;

//Perfect Implementation of Bellman Ford algorithm but the algorithm comes with a lot of tradeoffs
//It keeps reducing the costs even though not needed till n-1 relaxations are complete
//We are able to detect negative cycle detection at the nth relaxation
//Point is Bellman Ford is able to detect the shortest Path from a single source to all nodes if no negative weight is involved
//Mathematically there is no way to detect the shortest path in case of a negative weight cycle
//Thus, in my previous commits I have tried to trace the shortest distance and path, but now I will remove the code as it's not optimal

public class BellmanFord {

    private List<Integer> algorithm(int[][] edges, int n, int src){
        List<Integer> shortestDistances = new ArrayList<>();
        for(int i=0;i<n;i++){
           Integer shortestDistance = i==src?0:null;
           shortestDistances.add(shortestDistance);
        }
        for(int i=0;i<n-1;i++){
            for(int[] j: edges){
                if(shortestDistances.get(j[0])!=null){
                    int cost = shortestDistances.get(j[0])+j[2];
                    Integer prevShortestDistance = shortestDistances.get(j[1]);
                    if(prevShortestDistance==null || cost<prevShortestDistance){
                        shortestDistances.set(j[1], cost);
                    }
                }
            }
        }

        boolean negativeCycle = false;

        for(int[] j : edges){
            if(shortestDistances.get(j[0]) != null){

                int cost = shortestDistances.get(j[0]) + j[2];
                Integer prevShortestDistance = shortestDistances.get(j[1]);

                if(prevShortestDistance == null || cost < prevShortestDistance){
                    negativeCycle = true;
                    break;
                }
            }
        }

        return shortestDistances;
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
        BellmanFord obj = new BellmanFord();
        List<Integer> result = obj.algorithm(edges, n, src);
        for(int i=0;i<n;i++){
            System.out.println(src+" -> "+i+" , Shortest Distance -> "+result.get(i));
        }
    }

}
