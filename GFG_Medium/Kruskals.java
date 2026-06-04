package GFG_Medium;

//DSU - Cycle Detection
//If you are about to connect two nodes that already belong to the exact same group, you have found a cycle.
//Mechanically, DSU does not scan an existing graph to find a cycle.
//It blocks a cycle from happening the exact millisecond you try to connect two nodes.

public class Kruskals {

    int[] treeCost;
    int[] rank;
    int[] parent;

    public static final int INF = Integer.MAX_VALUE;

    private static class MinHeap{
        int[] heap;
        int[] srcHeap;
        int[] destHeap;
        int top;

        MinHeap(int length){
            this.heap = new int[length+1];
            this.destHeap = new int[length+1];
            this.srcHeap = new int[length+1];
            this.top = 1;
        }

        public void insert(int n, int src, int dest){
            heap[top] = n;
            srcHeap[top] = src;
            destHeap[top] = dest;
            int tempIndex = top++;
            while(tempIndex!=1 && heap[tempIndex]<heap[tempIndex/2]){
                swap(tempIndex,tempIndex/2);
                tempIndex = tempIndex/2;
            }
        }

        private void swap(int p1, int p2){
            int temp = heap[p1];
            heap[p1] = heap[p2];
            heap[p2] = temp;

            temp = destHeap[p1];
            destHeap[p1] = destHeap[p2];
            destHeap[p2] = temp;

            temp = srcHeap[p1];
            srcHeap[p1] = srcHeap[p2];
            srcHeap[p2] = temp;
        }

        public int[] delete(){
            int[] result = new int[]{heap[1], srcHeap[1], destHeap[1]};
            swap( 1, --top);
            int tempIndex = 1;
            while(tempIndex*2<top) {
                int lIndex = tempIndex * 2;
                if ((lIndex + 1) < top && heap[lIndex] > heap[lIndex + 1]) lIndex += 1;
                if (heap[lIndex] < heap[tempIndex]) {
                    swap(lIndex, tempIndex);
                    tempIndex = lIndex;
                } else break;
            }
            return result;
        }

        public boolean isEmpty(){
            return this.top==1;
        }
    }

    private int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }

    private void union(int n1, int n2, int wt){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1!=p2) {
            int s1 = rank[p1];
            int s2 = rank[p2];
            if (s1 >= s2) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
                treeCost[p1] += (wt+treeCost[p2]);
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
                treeCost[p2] += (wt+treeCost[p1]);
            }
        }
    }

    public int kruskalsMST(int v, int[][] edges){
        boolean[] visited = new boolean[v];
        MinHeap heap = new MinHeap(edges.length);

        treeCost = new int[v];
        rank = new int[v];
        parent = new int[v];
        for(int i=0;i<v;i++){
            rank[i] = 1;
            parent[i] = i;
            treeCost[i] = 0;
        }

        for(int[] i: edges){
            heap.insert(i[2], i[0], i[1]);
        }

        while(!heap.isEmpty()){
            int[] out = heap.delete();
            int node1 = out[1];
            int node2 = out[2];
            union(node1, node2, out[0]);
        }

        //Returning the result considering all the nodes are connected
        for(int i=0;i<v;i++){
           if(parent[i]==i) return treeCost[i];
        }

        //Returning the result considering there are disconnected components in the graph
        //Returns the cost of the most minimum spanning tree out in the MST forest(forest cuz multiple MSTs)
        int result = Integer.MAX_VALUE;
        for(int i=0;i<v;i++){
            if(parent[i]==i) result = Math.min(treeCost[i], result);
        }

        return result;
    }
}
