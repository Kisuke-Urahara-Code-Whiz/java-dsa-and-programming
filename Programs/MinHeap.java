package Programs;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private final List<Integer> heap;

    MinHeap(){
        heap = new ArrayList<>();
        heap.add(null);
    }

    private int getRoot(){
        return heap.get(1);
    }
    private boolean isEmpty(){
        return heap.size()==1;
    }

    public String getMin(){
        if(isEmpty()) return "Heap is empty";
        return getRoot()+" is the minimum";
    }

    public void insertion(int ele){
        int index = heap.size();
        heap.addLast(ele);
        boolean flag = true;
        while(index/2!=0 && flag){
            if(heap.get(index/2)>heap.get(index)){ swap(index/2, index); index = index/2; }
            else flag = false;
        }
    }

    private void swap(int p1, int p2){
        int temp = heap.get(p1);
        heap.set(p1, heap.get(p2));
        heap.set(p2, temp);
    }

    public String delete(){
        if(isEmpty()) return "Heap is empty";
        swap(1, heap.size()-1);
        int top = heap.removeLast();
        int i = 1;
        while(2*i<=heap.size()-1){
            int rightidx = 2*i+1;
            int leftidx = 2*i;
            int smallestidx = leftidx;
            if(rightidx<=heap.size()-1 && heap.get(rightidx)<heap.get(leftidx)) smallestidx=rightidx;
            if(heap.get(smallestidx)<heap.get(i)){ swap(smallestidx, i); i=smallestidx; }
            else break;
        }
        return top+" is removed";
    }
}
