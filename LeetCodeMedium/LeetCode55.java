package LeetCodeMedium;

//Backward Greedy Approach
public class LeetCode55 {
    public boolean canJump(int[] nums){
        if(nums.length==1) return true;
        int destination = nums.length - 1;
        int currentIdx = nums.length-2;
        while(currentIdx!=0){
            if(nums[currentIdx]>=destination-currentIdx) destination = currentIdx;
            currentIdx-=1;
        }
        return nums[0]>=destination;
    }
}
