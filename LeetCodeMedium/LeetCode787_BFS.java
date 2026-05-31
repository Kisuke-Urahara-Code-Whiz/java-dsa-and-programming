package LeetCodeMedium;

import java.util.*;

public class LeetCode787_BFS {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[src] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0];
                int currentPrice = curr[1];

                for (int[] neighbor : adj[u]) {
                    int v = neighbor[0];
                    int priceToV = neighbor[1];

                    if (currentPrice + priceToV < minCosts[v]) {
                        minCosts[v] = currentPrice + priceToV;
                        queue.offer(new int[]{v, minCosts[v]});
                    }
                }
            }
            stops++;
        }

        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
    }

}
