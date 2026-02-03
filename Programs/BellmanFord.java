package Programs;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    private Result algorithm(int[][] edges, int n, int src){
        int[] predecessors = new int[n];
        int[] shortestPathCounts = new int[n];
        List<Integer> shortestDistances = new ArrayList<>();
        for(int i=0;i<n;i++){
           int predecessor = -1;
           int shortestPathCount = i==src?0:-1;
           Integer shortestDistance = i==src?0:null;
           predecessors[i] = predecessor;
           shortestPathCounts[i] = shortestPathCount;
           shortestDistances.add(shortestDistance);
        }
        for(int i=0;i<n-1;i++){
            for(int[] j: edges){
                if(shortestDistances.get(j[0])!=null){
                    int cost = shortestDistances.get(j[0])+j[2];
                    Integer prevShortestDistance = shortestDistances.get(j[1]);
                    if(prevShortestDistance==null || cost<prevShortestDistance){
                        shortestDistances.set(j[1], cost);
                        shortestPathCounts[j[1]] = shortestPathCounts[j[0]]+1;
                        predecessors[j[1]] = j[0];
                    } else if(cost==prevShortestDistance){
                        if(shortestPathCounts[j[0]]+1<shortestPathCounts[j[1]]){
                            shortestPathCounts[j[1]] = shortestPathCounts[j[0]]+1;
                            predecessors[j[1]] = j[0];
                        }
                    }
                }
            }
        }
        return new Result(predecessors, shortestPathCounts, shortestDistances);
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
        Result result = obj.algorithm(edges, n, src);
        List<Integer> shortestDistances = result.getShortestDistances();
        int[] predecessors = result.getPredecessors();
        int[] shortestPathCounts = result.getShortestPathCounts();
        for(int i=0;i<n;i++){
            System.out.println(src+" -> "+i+" , Shortest Distance -> "+shortestDistances.get(i)+" , Path = "+obj.getPath(shortestPathCounts[i], predecessors, i));
        }
    }

    private String getPath(int pathCount, int[] predecessor, int destination){
        int node = destination;
        StringBuilder str = new StringBuilder();
        while(node!=-1){
            str.append(" <- ").append(node);
            node = predecessor[node];
        }
        return new String(str).substring(3);
    }

}
