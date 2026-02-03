package Programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Djikstra_Algo {

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
        Djikstra_Algo obj = new Djikstra_Algo();
        Result result = obj.algorithm(edges, src, n);
        List<Integer> shortestDistances = result.getShortestDistances();
        int[] predecessors = result.getPredecessors();
        for(int i=0;i<n;i++){
            System.out.println(src+" -> "+i+" , Shortest Distance -> "+shortestDistances.get(i)+" , ShortestDistancePath -> [ "+obj.displayPath(i, predecessors)+" ]");
        }
    }

    private class Minheap{

        private final List<Integer> weights;
        private final List<Integer> nodes;
        HashMap<Integer, Integer> indexes;

        Minheap(){
            this.weights = new ArrayList<>();
            this.nodes = new ArrayList<>();
            this.indexes = new HashMap<>();
            weights.add(null);
            nodes.add(null);
        }

        public boolean isEmpty(){
            return weights.size()==1;
        }

        private void lesserReorder(int index){
            while(2*index<=weights.size()-1){
                int smallestIndex = 2*index;
                int rightIndex = 2*index+1;
                if(rightIndex<=weights.size()-1 && weights.get(rightIndex)< weights.get(smallestIndex)) smallestIndex = rightIndex;
                if(weights.get(smallestIndex)< weights.get(index)){
                    swap(smallestIndex, index);
                    index = smallestIndex;
                } else break;
            }
        }

        private void greaterReorder(int index){
            while(index/2>=1){
                int greaterIndex = index/2;
                if(weights.get(greaterIndex)> weights.get(index)){
                    swap(greaterIndex, index);
                    index = index/2;
                } else break;
            }
        }

        private void swap(int p1, int p2){
            int temp = weights.get(p1);
            weights.set(p1, weights.get(p2));
            weights.set(p2, temp);

            temp = nodes.get(p1);
            nodes.set(p1, nodes.get(p2));
            nodes.set(p2, temp);

            indexes.put(nodes.get(p1), p1);
            indexes.put(nodes.get(p2), p2);
        }

        private void reorder(int node, int weight){
            int index = indexes.get(node);
            weights.set(index, weight);
            if(index/2>=1 && weights.get(index/2)>weights.get(index)) greaterReorder(index);
            else lesserReorder(index);
        }

        public void insert(int node, int weight){
            if(indexes.containsKey(node)) reorder(node, weight);
            else{
                weights.add(weight);
                nodes.add(node);
                greaterReorder(weights.size()-1);
            }
        }

        public int[] delete(){
            int[] deleted = new int[]{nodes.get(1), weights.get(1)};
            if(weights.size()!=2) swap(1, weights.size()-1);
            weights.removeLast();
            nodes.removeLast();
            indexes.remove(deleted[0]);
            if(weights.size()!=1) lesserReorder(1);
            return deleted;
        }
    }

    private class Result{
        private final List<Integer> shortestDistances;
        private final int[] predecessors;

        Result(List<Integer> shortestDistances, int[] predecessors){
            this.shortestDistances = shortestDistances;
            this.predecessors = predecessors;
        }

        public List<Integer> getShortestDistances(){
            return this.shortestDistances;
        }

        public int[] getPredecessors(){
            return this.predecessors;
        }
    }

    public Result algorithm(int[][] edges, int src, int n){

        int[] predecessors = new int[n];
        List<Integer> shortestDistances = new ArrayList<>();
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        Minheap minHeap = new Minheap();

        for(int i=0;i<edges.length;i++){
            if(i==src) shortestDistances.add(0);
            else shortestDistances.add(null);

            if(predecessors[edges[i][0]]!=-1) predecessors[edges[i][0]] = -1;

            List<int[]> connections = graph.getOrDefault(edges[i][0], null);
            if(connections==null) { connections = new ArrayList<>(); graph.put(edges[i][0], connections); }
            connections.add(new int[]{edges[i][1], edges[i][2]});
        }

        minHeap.insert(src, 0);

        while(!minHeap.isEmpty()){
            int[] top = minHeap.delete();
            List<int[]> connections = graph.getOrDefault(top[0], null);
            if(connections!=null){
                int cost = shortestDistances.get(top[0]);
                for(int[] i:connections){
                    int currentCost = cost+i[1];
                    Integer currentShortestDistance = shortestDistances.get(i[0]);
                    if(currentShortestDistance==null || currentCost<currentShortestDistance){
                        minHeap.insert(i[0], currentCost);
                        shortestDistances.set(i[0], currentCost);
                        predecessors[i[0]] = top[0];
                    }
                }
            }
        }

        return new Result(shortestDistances, predecessors);
    }

    private String displayPath(int dest, int[] predecessors){
        String result = "";
        int node = dest;
        while(node!=-1){
            String str = " -> "+node;
            String str1 = result;
            result = str.concat(str1);
            node = predecessors[node];
        }
        return result.substring(4);
    }

}
