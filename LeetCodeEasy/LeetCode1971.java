package LeetCodeEasy;

import java.util.*;

public class LeetCode1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                List<Integer> list = graph.getOrDefault(edges[i][j],null);
                if(list==null){ list = new ArrayList<>(); graph.put(edges[i][j], list); }
                if(j==0) list.add(edges[i][j+1]);
                else list.add(edges[i][j-1]);
            }
        }
        Set<Integer> visited = new HashSet<>();
        return bfs(graph, visited, source, destination);
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int source, int destination){
        boolean result = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            for(int i=1;i<=levelLength;i++){
                int node = queue.poll();
                List<Integer> connections = graph.getOrDefault(node, null);
                if(connections!=null){
                    for(int k:connections){
                        if(!visited.contains(k)){
                            if(k==destination) {
                                result = true;
                                break;
                            } else {
                                visited.add(k);
                                queue.add(k);
                            }
                        }
                    }
                }
                if(result) break;
            }
            if(result) break;
            levelLength = queue.size();
        }
        return result;
    }

}
