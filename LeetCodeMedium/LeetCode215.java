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
        heap[index] = ele;
        while(index/2!=0 && heap[index/2]<heap[index]){
            swap(index, index/2, heap);
            index = index/2;
        }
    }

    private int delete(int[] heap, int index){
        int top = heap[1];
        swap(index, 1, heap);
        int i = 1;
        while(2*i<=index-1){
            int l = 2*i;
            int r = 2*i+1;
            int ldx = l;
            if(r<=index-1 && heap[r]>heap[l]) ldx = r;
            if(heap[ldx]>heap[i]){
                swap(ldx, i, heap);
                i = ldx;
            } else break;
        }
        return top;
    }

    static void main() {
        System.out.println(new LeetCode215().findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

}
