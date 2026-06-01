package LeetCodeEasy;

public class LeetCode2144 {

    private static class MaxHeap{
        int[] heap;
        int top;

        MaxHeap(int length){
            this.heap = new int[length];
            this.top = 1;
        }

        public int getSize(){
            return top-1;
        }

        public void insert(int n){
            heap[top] = n;
            int temp = top++;
            while(temp!=1 && heap[temp]>heap[temp/2]){
                swap(temp, temp/2);
                temp = temp/2;
            }
        }

        public int delete(){
            int result = heap[1];
            swap(1, --top);
            int temp = 1;
            while(temp*2<top){
                int lIndex = temp*2;
                if(lIndex+1<top && heap[lIndex]<heap[lIndex+1]) lIndex+=1;
                if(heap[lIndex]>heap[temp]){
                    swap(temp, lIndex);
                    temp = lIndex;
                } else break;
            }
            return result;
        }

        private void swap(int p1, int p2){
            int temp = heap[p1];
            heap[p1] = heap[p2];
            heap[p2] = temp;
        }
    }

    public int minimumCost(int[] cost) {
        if(cost.length==1) return cost[0];
        else if(cost.length==2) return cost[1]+cost[0];
        MaxHeap heap = new MaxHeap(cost.length+1);
        for(int i: cost){
            heap.insert(i);
        }
        int result = 0;
        while(heap.getSize()>2){
            result+= heap.delete() + heap.delete();
            heap.delete();
        }
        if(heap.getSize()==2) result+= heap.delete() + heap.delete();
        if(heap.getSize()==1) result+= heap.delete();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2144().minimumCost(new int[]{1,2,3}));
    }

}
