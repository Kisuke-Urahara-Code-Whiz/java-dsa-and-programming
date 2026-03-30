package Revision;

public class MaxHeap {

    int[] arr;
    int size;

    MaxHeap(int size){
        this.size = 0;
        arr = new int[(int)(Math.pow(2,(Math.floor(Math.log(size)/Math.log(2)))+1))];
    }

    private void swap(int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void insert(int n){
        arr[++size] = n;
        int idx = size;
        while(idx/2>0){
            int parentIdx = idx/2;
            if(arr[parentIdx]<arr[idx]){
                 swap(idx, parentIdx);
                 idx = parentIdx;
            } else break;
        }
    }

    public int delete(){
        swap(1,size);
        size-=1;
        int idx = 1;
        while(idx*2<=size){
            int smallestIdx = idx*2;
            if(idx*2+1<=size && arr[smallestIdx]<arr[idx*2+1]) smallestIdx+=1;
            if(arr[smallestIdx]>arr[idx]){
                swap(idx, smallestIdx);
                idx = smallestIdx;
            } else break;
        }
        return arr[size+1];
    }

    public int getMax(){
        if(!isEmpty()) return arr[1];
        else return -1;
    }

    private boolean isEmpty(){
        return size<1;
    }
}
