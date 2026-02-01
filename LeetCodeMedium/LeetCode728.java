package LeetCodeMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode728 {

    private class MinHeap{

        private final List<Integer> nodes;
        private final List<Integer> weights;
        private final HashMap<Integer, Integer> indexes;

        MinHeap(){
            this.nodes = new ArrayList<>();
            this.weights = new ArrayList<>();
            indexes = new HashMap<>();
            nodes.add(null);
            weights.add(null);

        }

        private void reorder(int node, int weight){
            int index = indexes.get(node);
            weights.set(index, weight);
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

        public void insert(int node, int weight){
            if(indexes.containsKey(node)) reorder(node, weight);
            else {
                nodes.add(node);
                weights.add(weight);
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
            int[] nodePath = new int[]{nodes.get(1), weights.get(1)};
            swap(1, nodes.size()-1);
            nodes.removeLast();
            weights.removeLast();
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


            indexes.put(node1, p2);
            indexes.put(node2, p1);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        MinHeap minHeap = new MinHeap();
        HashMap<Integer, Integer> shortestPaths = new HashMap<>();
        shortestPaths.put(src,0);
        minHeap.insert(src,0);
        for(int[] i: flights){
            List<int[]> connections = graph.get(i[0]);
            if(connections==null){ connections = new ArrayList<>(); graph.put(i[0],connections); }
            connections.add(new int[]{i[1],i[2]});
            if(i[0]!=src && !shortestPaths.containsKey(i[0])) shortestPaths.put(i[0],Integer.MAX_VALUE);
            if(i[1]!=src && !shortestPaths.containsKey(i[1])) shortestPaths.put(i[1],Integer.MAX_VALUE);
        }
        boolean flag = true;
        while(k!=-1){
            int[] node = minHeap.delete();
            if(node[0]==dst) return shortestPaths.get(dst);
            for(int[] i: graph.getOrDefault(node[0], null)){
                int shortest = shortestPaths.get(i[0]);
                if(i[1]+node[1]<shortest){
                    shortestPaths.put(i[0], i[1]+node[1]);
                    minHeap.insert(i[0], i[1]+node[1]);
                }
            }
            k-=1;
        }
        return shortestPaths.get(dst);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode728().findCheapestPrice(
                3,
                new int[][]{new int[]{0,1,100}, new int[]{1,2,100}, new int[]{0,2,500}},
                0,2,1
        ));
    }

}
