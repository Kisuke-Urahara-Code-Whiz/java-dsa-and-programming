package Programs;

public class EqualPartitionSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        else{
            sum = sum/2;
            SubsetSumsEqualsK obj = new SubsetSumsEqualsK();
            return obj.knapsack(nums, nums.length, sum);
        }
    }

}
