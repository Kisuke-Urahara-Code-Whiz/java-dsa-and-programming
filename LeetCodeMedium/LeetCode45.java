package LeetCodeMedium;

import java.util.Arrays;

public class LeetCode45 {

    //1D - DP Approach

    public int jump(int[] nums) {

        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length - 1);

        int destination = nums.length-1;
        dp[destination] = 0;
        int idx = nums.length-2;

        while(idx>=0){
            int tempIdx = destination;
            while(tempIdx>=idx+1){
                if(dp[tempIdx]<destination && nums[idx]>=tempIdx-idx){
                    dp[idx] = Math.min(dp[idx], dp[tempIdx] + 1);
                } tempIdx-=1;
            }
            idx-=1;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode45().jump(new int[]{2,3,1,1,4}));
    }
}
