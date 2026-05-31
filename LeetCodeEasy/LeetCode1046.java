package LeetCodeEasy;

public class LeetCode1046 {

    private static class MaxHeap {

        int[] arr;
        int top;

        MaxHeap(int size) {
            this.arr = new int[size+1];
            this.top = 1;
        }

        private void swap(int idx1, int idx2) {
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }

        public void add(int n) {
            arr[top] = n;
            int idx = top++;
            while (idx / 2 > 0) {
                int parentIdx = idx / 2;
                if (arr[parentIdx] < arr[idx]) {
                    swap(idx, parentIdx);
                    idx = parentIdx;
                } else break;
            }
        }

        public int remove() {
            swap(1, top-1);
            top-=1;
            int idx = 1;
            while (idx * 2 < top) {
                int smallestIdx = idx * 2;
                if (smallestIdx + 1 < top && arr[smallestIdx] < arr[smallestIdx + 1]) smallestIdx += 1;
                if (arr[smallestIdx] > arr[idx]) {
                    swap(idx, smallestIdx);
                    idx = smallestIdx;
                } else break;
            }
            return arr[top];
        }
        public int size() { return top-1; }

    }

    public int lastStoneWeight(int[] stones) {
        MaxHeap heap = new MaxHeap(stones.length);
        for(int i: stones){
            heap.add(i);
        }
        while(heap.size()>1){
            int a = heap.remove();
            int b = heap.remove();
            if(a!=b) heap.add(Math.abs(a-b));
        }
        if(heap.size()==0) return 0;
        return heap.remove();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1046().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
