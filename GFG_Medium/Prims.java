package GFG_Medium;

import java.util.Scanner;

//Classic Prims
//Algorithm runs thinking that there is a spanning tree possible
public class Prims {

    public static final int INF = Integer.MAX_VALUE;

    private static class MinHeap{
        int[] heap;
        int[] destHeap;
        int top;

        MinHeap(int length){
            this.heap = new int[length+1];
            this.destHeap = new int[length+1];
            this.top = 1;
        }

        public void insert(int n, int dest){
            heap[top] = n;
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
        }

        public int[] delete(){
            int[] result = new int[]{heap[1], destHeap[1]};
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

    public int prims(int v, int[][] edges, int src){
        int shortestEdge = Integer.MAX_VALUE;
        boolean[] visited = new boolean[v];
        MinHeap heap = new MinHeap((v*v)+1);
        int[][] graph = new int[v][v];

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph[i][j] = INF;
            }
        }

        int result = 0;
        for(int[] i: edges){
            graph[i[0]][i[1]] = i[2];
            graph[i[1]][i[0]] = i[2];
        }

        visited[src] = true;
        for(int i=0;i<v;i++){
            if(!visited[i] && graph[src][i]!=INF){
                heap.insert(graph[src][i], i);
            }
        }

        while(!heap.isEmpty()){
            int[] out = heap.delete();
            if(!visited[out[1]]){
                result+=out[0];
                visited[out[1]] = true;
                src = out[1];
                for(int i=0;i<v;i++){
                    if(!visited[i] && graph[src][i]!=INF){
                        heap.insert(graph[src][i], i);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes : ");
        int n = sc.nextInt();
        System.out.println("Enter the number of vertices : ");
        int v = sc.nextInt();
        int[][] edges = new int[v][3];
        for(int i=0;i<v;i++){
            System.out.println("Enter node 1 : " );
            edges[i][0] = sc.nextInt();
            System.out.println("Enter node 2 : " );
            edges[i][1] = sc.nextInt();
            System.out.println("Enter weight : ");
            edges[i][2] = sc.nextInt();
        }
        System.out.println(new Prims().prims(n, edges, 1));
    }

}
