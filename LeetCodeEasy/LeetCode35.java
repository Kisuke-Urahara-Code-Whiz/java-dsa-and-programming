package LeetCodeEasy;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int result = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){ result = mid; break; }
            else if(nums[mid]<target){ result = mid+1; l=mid+1; }
            else r=mid-1;
        }
        return result==-1? 0 :result;
    }

    static void main() {
        System.out.println(new LeetCode35().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new LeetCode35().searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(new LeetCode35().searchInsert(new int[]{1,3,5,6}, 2));
    }

}
