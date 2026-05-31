package Revision;

import java.util.Arrays;

public class Djikstra_Algo {

    final static int INF = 99999;

    public static void main(String[] args) {
        int[][] graph = {
                { 0,  4,  2, -1, -1},
                { 4,  0,  1,  5, -1},
                { 2,  1,  0,  8, 10},
                {-1,  5,  8,  0,  2},
                {-1, -1, 10,  2,  0}
        };

        int n = graph.length;

        for(int i = 0; i<n; i++){

            int[] shortestDistances = new int[n];
            Djikstra_MinHeap heap = new Djikstra_MinHeap(n);
            Arrays.fill(shortestDistances, INF);

            heap.insert(i, 0);

            while(!heap.isEmpty()) {
                int[] nodeResult = heap.delete();
                int node = nodeResult[0];
                shortestDistances[node] = nodeResult[1];
                for (int j = 0; j < n; j++) {
                    if (node != j && shortestDistances[j]==INF && graph[node][j] != -1)
                        heap.insert(j, shortestDistances[node] + graph[node][j]);
                }
            }

            System.out.println("Source -> "+i);
            for(int j=0;j<n;j++){
                System.out.println(j+" -> "+shortestDistances[j]);
            }
            System.out.println();

        }

    }

}
