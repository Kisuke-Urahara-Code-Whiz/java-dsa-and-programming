package LeetCodeMedium;

public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        else{
            sum = sum/2;
            return knapsack(nums, nums.length, sum);
        }
    }

    public boolean knapsack(int[] arr, int n, int s){
        boolean[][] dp = new boolean[n+1][s+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=s;j++){
                if (arr[i - 1] <= j) dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s];
    }

}
