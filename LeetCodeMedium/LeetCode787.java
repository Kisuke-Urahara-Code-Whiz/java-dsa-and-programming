package LeetCodeMedium;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode787 {

    static class HeapResult{

        int distance;
        int node;
        int stops;

        HeapResult(int distance, int node, int stops){
            this.distance = distance;
            this.node = node;
            this.stops = stops;
        }

    }

    static class MinHeap{

        int[] nodeHeap;
        int[] distanceHeap;
        int[] levelHeap;
        int dest;
        int stops;
        int currLength;
        int length;

        MinHeap(int n, int dest, int stops){
            length = (n*(n-1))/2;
            nodeHeap = new int[length+1];
            distanceHeap = new int[length+1];
            levelHeap = new int[length+1];
            this.dest = dest;
            this.stops = stops+1;
            currLength = 0;
        }

        void insert(int node, int wt, int stop){
            if(stop<stops || (stop==stops && node==dest)){
                currLength+=1;
                nodeHeap[currLength] = node;
                distanceHeap[currLength] = wt;
                levelHeap[currLength] = stop;
                int tempIndex = currLength;
                while(tempIndex!=1 && distanceHeap[tempIndex]<distanceHeap[tempIndex/2]){
                    swap(tempIndex, tempIndex/2);
                    tempIndex = tempIndex/2;
                }
            }
        }

        boolean isEmpty(){
            return currLength == 0;
        }

        HeapResult delete(){

            int resultNode = nodeHeap[1];
            int resultWt = distanceHeap[1];
            int resultLevel = levelHeap[1];
            HeapResult result = new HeapResult(resultWt, resultNode, resultLevel);

            swap(1, currLength);
            currLength-=1;

            int tempIndex = 1;
            while(tempIndex*2<=currLength){
                int lIndex = tempIndex*2;
                if(lIndex+1<=currLength && distanceHeap[lIndex]>distanceHeap[lIndex+1]) lIndex+=1;
                if(distanceHeap[lIndex]<distanceHeap[tempIndex]){
                    swap(lIndex, tempIndex);
                    tempIndex = lIndex;
                } else break;
            }

            return result;
        }

        private void swap(int p1, int p2){

            int tempNode = nodeHeap[p1];
            nodeHeap[p1] = nodeHeap[p2];
            nodeHeap[p2] = tempNode;

            int tempWt = distanceHeap[p1];
            distanceHeap[p1] = distanceHeap[p2];
            distanceHeap[p2] = tempWt;

            int tempLevel = levelHeap[p1];
            levelHeap[p1] = levelHeap[p2];
            levelHeap[p2] = tempLevel;

        }

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        int[][] graph = new int[n][n];
        for(int i=0;i<flights.length;i++){
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
            ArrayList<Integer> indexList = hashMap.getOrDefault(flights[i][0], new ArrayList<>());
            indexList.add(flights[i][1]);
            hashMap.put(flights[i][0], indexList);
        }

        MinHeap heap = new MinHeap(n, dst, k);
        heap.insert(src, 0, 0);

        while(!heap.isEmpty()){

            HeapResult result = heap.delete();
            if(result.node == dst) return result.distance;

            ArrayList<Integer> connections = hashMap.getOrDefault(result.node, null);
            if(connections!=null){
                for(int i: connections){
                    heap.insert(i, result.distance + graph[result.node][i], result.stops+1);
                }
            }

        }

        return -1;
    }
}
