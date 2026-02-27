package LeetCodeEasy;

public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while(r<nums.length){
            if(nums[r]!=0){
                swap(nums,l,r);
                l+=1;
            }
            r+=1;
        }
    }

    private void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
