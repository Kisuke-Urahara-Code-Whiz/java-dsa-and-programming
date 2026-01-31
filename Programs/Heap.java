package Programs;

import java.util.List;

public class Heap {

    static void main() {
        MinHeap heap = new MinHeap();
        List<Integer> list = List.of(8,7,10,13,14,11,9,5,12);
        for(int i:list){
            System.out.println(heap.getMin());
            heap.insertion(i);
        }
        for(int i=0;i<=list.size();i++){
            System.out.println(heap.delete());
        }
    }
}
