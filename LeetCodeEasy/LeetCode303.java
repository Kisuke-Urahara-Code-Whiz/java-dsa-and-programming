package LeetCodeEasy;

public class LeetCode303 {

    int[] arr;
    public LeetCode303(int[] nums) {
        this.arr = nums;
        prefixSum();
    }

    public int sumRange(int left, int right) {
        if(left==0) return arr[right];
        return arr[right]-arr[left-1];
    }

    private void prefixSum(){
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i];
        }
    }

    static void main() {
        LeetCode303 obj = new LeetCode303(new int[]{-2,0,3,-5,2,-1});
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }

}
