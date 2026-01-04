package LeetCodeEasy;

public class LeetCode704 {

    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return 0;
        else if(nums.length == 1) return -1;
        return asc(nums,target);
    }

    public int asc(int[] arr, int search){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==search) return mid;
            else if(arr[mid]>search) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

}
