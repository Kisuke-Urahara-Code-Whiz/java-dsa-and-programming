package Programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        boolean flag = true;
        if(!isEmpty()){
            int i = 1;
            int size = heap.size()-1;
            while(2*i<=size){
                if(heap.get(i)>heap.get(2*i)) swap(i,2*i);
                else if(2*i+1<=size && heap.get(i)>heap.get(2*i+1)) swap(i,2*i+1);
                else i+=1;
            }
        }
        return top+" was removed";
    }

}
