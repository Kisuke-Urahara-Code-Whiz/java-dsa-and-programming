package Revision;

public class MinHeap {

    int index;
    int length;
    int[] heap;

    MinHeap(int n){
        this.length = n;
        this.index = 0;
        this.heap = new int[length];
    }

    public void insert(int n){
        if((index+1)==length) return;
        heap[++index] = n;
        int tempIndex = index;
        while(tempIndex!=1 && heap[tempIndex]<heap[tempIndex/2]){
            swap(tempIndex,tempIndex/2);
            tempIndex = tempIndex/2;
        }
    }

    private void swap(int p1, int p2){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    public int delete(){
        if(index==0) return -1;
        swap( 1, index);
        int result = heap[index--];
        int tempIndex = 1;
        while(tempIndex*2<=index){
            int lIndex = tempIndex*2;
            if((lIndex+1)<=index && heap[lIndex]>heap[lIndex+1]) lIndex+=1;
            if(heap[lIndex]<heap[tempIndex]){
                swap(lIndex, tempIndex);
                tempIndex = lIndex;
            } else break;
        }
        return result;
    }

    public int getMin(){
        if(index!=0) return heap[1];
        else return -1;
    }

    public boolean isEmpty(){
        return index==0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,43,2,6,3,2};
        MinHeap obj = new MinHeap(arr.length+1);
        for(int i:arr){
            obj.insert(i);
        }
        while(!obj.isEmpty()){
            System.out.println(obj.delete()+" ");
        }
    }
}
