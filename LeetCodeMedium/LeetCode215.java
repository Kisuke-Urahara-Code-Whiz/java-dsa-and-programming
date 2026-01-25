package LeetCodeMedium;

public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        int[] heap = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            insert(heap, nums[i], i+1);
        }
        int index = heap.length-1;
        int result = 0;
        while(k!=0){
            result = delete(heap, index);
            index-=1;
            k-=1;
        }
        return result;
    }

    private void swap(int p1, int p2, int[] heap){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    private void insert(int[] heap, int ele, int index){
        boolean flag = true;
        while(index/2!=0 && flag){
            if(heap[index/2]<heap[index]){ swap(index/2, index, heap); index = index/2; }
            else flag = false;
        }
    }

    private int delete(int[] heap, int index){
        swap(1, index, heap);
        int top = heap[index];
        boolean flag = true;
        int i = 1;
        while(2*i<=index) {
            if (heap[i] > heap[2 * i]) swap(i,2 * i,heap);
            else if (2 * i + 1 <= index && heap[index] > heap[2 * i + 1]) swap(i, 2 * i + 1, heap);
            else i += 1;
        }
        return top;
    }

    static void main() {
        System.out.println(new LeetCode215().delete(new int[]{3,2,1,5,6,4},2));
    }

}
