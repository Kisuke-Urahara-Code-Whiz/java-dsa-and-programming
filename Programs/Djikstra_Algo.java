package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Djikstra_Algo {

    private class MinHeap{

        private final List<Integer> nodes;
        private final List<Integer> weights;
        private final HashMap<Integer, Integer> indexes;
        private final List<List<Integer>> paths;

        MinHeap(){
            this.nodes = new ArrayList<>();
            this.weights = new ArrayList<>();
            this.paths = new ArrayList<>();
            indexes = new HashMap<>();
            paths.add(null);
            nodes.add(null);
            weights.add(null);

        }

        public boolean isEmpty(){
            return !(nodes.size()>1);
        }

        private void reorder(int node, int weight){
            int index = indexes.get(node);
            if(index!=1 && weights.get(index)<weights.get(index/2)){
                while (index / 2 >= 1 && weights.get(index) < weights.get(index / 2)) {
                    swap(index, index / 2);
                    index = index / 2;
                    indexes.put(node, index);
                }
            } else {
                int smallestIndex;
                boolean flag = true;
                while(index*2<nodes.size()-1 && flag){
                    smallestIndex = 2*index;
                    if(2*index+1<nodes.size()-1 && weights.get(2*index+1)<weights.get(smallestIndex)) smallestIndex=2*index+1;
                    if(weights.get(index)> weights.get(smallestIndex)){
                        swap(index, smallestIndex);
                        index = smallestIndex;
                    } else flag = false;
                }
            }
        }

        public void insert(int node, int weight, int pathRemaining){
            if(indexes.containsKey(node)) reorder(node, weight, pathRemaining);
            else {
                nodes.add(node);
                weights.add(weight);
                pathsRemaining.add(pathRemaining);
                int index = weights.size() - 1;
                indexes.put(node, index);
                while (index / 2 >= 1 && weights.get(index) < weights.get(index / 2)) {
                    swap(index, index / 2);
                    index = index / 2;
                    indexes.put(node, index);
                }
            }
        }

        public int[] delete(){
            int[] nodePath = new int[]{nodes.get(1), weights.get(1), pathsRemaining.get(1)};
            swap(1, nodes.size()-1);
            nodes.removeLast();
            weights.removeLast();
            pathsRemaining.removeLast();
            int index = 1;
            int smallestIndex;
            boolean flag = true;
            while(index*2<nodes.size()-1 && flag){
                smallestIndex = 2*index;
                if(2*index+1<nodes.size()-1 && weights.get(2*index+1)<weights.get(smallestIndex)) smallestIndex=2*index+1;
                if(weights.get(index)> weights.get(smallestIndex)){
                    swap(index, smallestIndex);
                    index = smallestIndex;
                } else flag = false;
            }
            return nodePath;
        }

        private void swap(int p1, int p2) {

            int node1 = nodes.get(p1);
            int node2 = nodes.get(p2);
            nodes.set(p1, node2);
            nodes.set(p2, node1);


            int weight1 = weights.get(p1);
            int weight2 = weights.get(p2);
            weights.set(p1, weight2);
            weights.set(p2, weight1);

            int pathRemaining1 = pathsRemaining.get(p1);
            int pathRemaining2 = pathsRemaining.get(p2);
            pathsRemaining.set(p1, pathRemaining2);
            pathsRemaining.set(p2, pathRemaining1);


            indexes.put(node1, p2);
            indexes.put(node2, p1);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1, 4}, {0, 2, 2},
                {1, 2, 10}, {1, 3, 5},
                {2, 4, 3},
                {3, 5, 1},
                {4, 3, 1}, {4, 5, 5}
        };
        int src = 0;
        System.out.println("Testing Dijkstra's Algorithm...");

    }

    private HashMap<Integer, int[]> generalDjikstra(int src, int[][] connections, int n){
        HashMap<Integer, int[]> result = new HashMap<>();
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        MinHeap minHeap = new MinHeap();
        int[] shortestPaths = new int[n];
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        for(int[] i: connections){
            List<int[]> paths = graph.getOrDefault(i[0], null);
            if(paths==null){ paths = new ArrayList<>(); graph.put(i[0], paths); }
            paths.add(new int[]{i[1], i[2]});
        }
        shortestPaths[src] = 0;
        minHeap.insert(0, 0);

    }

}
