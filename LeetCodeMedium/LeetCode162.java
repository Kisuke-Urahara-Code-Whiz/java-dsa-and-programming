package LeetCodeMedium;

public class LeetCode162 {

    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            if(l==r) return l;
            int mid = l+(r-l)/2;
            if(mid==l && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            else if(nums[mid+1]>nums[mid]) l = mid+1;
            else r = mid-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode162().findPeakElement(new int[]{1,2,3,1}));
    }

}
