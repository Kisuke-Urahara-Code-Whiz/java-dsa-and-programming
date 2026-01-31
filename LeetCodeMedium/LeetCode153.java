package LeetCodeMedium;

public class LeetCode153 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[l]) r = mid;
            else if(nums[mid]>nums[r]) l = mid+1;
            else break;
        }
        return nums[l];
    }

}
