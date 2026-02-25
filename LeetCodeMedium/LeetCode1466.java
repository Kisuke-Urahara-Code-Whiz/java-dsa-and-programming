package LeetCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode1466 {

    //BFS
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] c : connections) {
            adj[c[0]].add(new int[]{c[1], 1});
            adj[c[1]].add(new int[]{c[0], 0});
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int[] edge : adj[curr]) {
                if (!visited[edge[0]]) {
                    count += edge[1];
                    visited[edge[0]] = true;
                    q.offer(edge[0]);
                }
            }
        }
        return count;
    }

    //DFS
    int count = 0;

    public int minReorde(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] c : connections) {
            adj[c[0]].add(new int[]{c[1], 1});
            adj[c[1]].add(new int[]{c[0], 0});
        }

        dfs(0, new boolean[n], adj);
        return count;
    }

    private void dfs(int curr, boolean[] visited, List<int[]>[] adj) {
        visited[curr] = true;
        for (int[] edge : adj[curr]) {
            if (!visited[edge[0]]) {
                count += edge[1];
                dfs(edge[0], visited, adj);
            }
        }
    }
}
