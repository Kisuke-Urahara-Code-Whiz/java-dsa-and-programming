package Revision;

public class Djikstra_MinHeap {

    int[] nodeHeap;
    int[] pathHeap;
    int[] indexes;
    int index;
    int length;

    Djikstra_MinHeap(int n){
        this.nodeHeap = new int[n+1];
        this.pathHeap = new int[n+1];
        this.indexes = new int[n];
        for(int i = 0; i<n; i++){
            indexes[i] = -1;
        }
        this.index = 0;
        this.length = n;
    }

    void insert(int node, int value){
        if(indexes[node] == -1){
            index+=1;
            nodeHeap[index] = node;
            pathHeap[index] = value;
            indexes[node] = index;
            goUp(index);
        } else if(pathHeap[indexes[node]]>value){
            pathHeap[indexes[node]] = value;
            goUp(indexes[node]);
        }
    }

    int[] delete(){

        int resultNode = nodeHeap[1];
        int resultCost = pathHeap[1];
        int[] result = new int[]{resultNode, resultCost};
        indexes[resultNode] = -1;

        swap(1, index);
        index-=1;

        goDown();
        return result;

    }

    private void goUp(int index){
        while(index!=1 && pathHeap[index]<pathHeap[index/2]){
            swap(index, index/2);
            index = index/2;
        }
    }

    private void goDown(){
        int tempIndex = 1;
        while((tempIndex*2)<=index){
            int lIndex = tempIndex*2;
            if((lIndex+1)<=index && pathHeap[lIndex+1]<pathHeap[lIndex]) lIndex+=1;
            if(pathHeap[lIndex]<pathHeap[tempIndex]){
                swap(lIndex, tempIndex);
                tempIndex = lIndex;
            } else break;
        }
    }

    private void swap(int p1, int p2){

        int temp = nodeHeap[p1];
        nodeHeap[p1] = nodeHeap[p2];
        nodeHeap[p2] = temp;

        temp = pathHeap[p1];
        pathHeap[p1] = pathHeap[p2];
        pathHeap[p2] = temp;

        indexes[nodeHeap[p1]] = p1;
        indexes[nodeHeap[p2]] = p2;

    }

    public boolean isEmpty(){
        return index==0;
    }

}
