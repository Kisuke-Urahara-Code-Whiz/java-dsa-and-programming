package LeetCodeMedium;

import java.util.*;

public class LeetCode1466 {

    int connectedCount = 0;
    int reorders = 0;

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new HashSet<>());
        }
        for(int[] i: connections){
            Set<Integer> list = graph.getOrDefault(i[1],null);
            list.add(i[0]);
        }
        boolean[] connected = new boolean[n];
        connected[0] = true;
        connectedCount+=1;
        for(int i:graph.get(0)){
            connected[i] = true;
            connectedCount+=1;
        }
        while(connectedCount != n){
            for(int i=1;i<n;i++){
                reorder(connected, graph, i);
            }
        }

        return reorders;
    }

    private void reorder(boolean[] connected, HashMap<Integer, Set<Integer>> graph, int node){
        if(connected[node]){
            for(int i:graph.get(node)){
                if(!connected[i]){
                    connected[i] = true;
                    connectedCount+=1;
                }
            }
        } else {
            for (int i : graph.get(node)) {
                if (connected[i]) {
                    connected[node] = true;
                    graph.get(node).remove(i);
                    graph.get(i).add(node);
                    reorders += 1;
                    connectedCount+=1;
                    break;
                }
            }
            if(connected[node]){
                for(int i:graph.get(node)){
                    if(!connected[i]){
                        connected[i] = true;
                        connectedCount+=1;
                        reorder(connected, graph, i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1466().minReorder(6, new int[][] {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        }));
    }

}
