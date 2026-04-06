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
        Boolean[][] dp = new Boolean[n+1][s+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else dp[i][j] = null;
            }
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
