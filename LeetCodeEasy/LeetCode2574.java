package LeetCodeEasy;

import java.util.Arrays;

public class LeetCode2574 {
    public int[] leftRightDifference(int[] nums) {
        int[] rSum = new int[nums.length];
        int[] lSum = new int[nums.length];
        int l = 0;
        int r = nums.length-1;
        while(l!= nums.length-1){
            rSum[r-1] = rSum[r] + nums[r];
            lSum[l+1] = lSum[l] + nums[l];
            l++;
            r--;
        }

        for(int i=0;i< nums.length;i++){
            nums[i] = Math.abs(lSum[i] - rSum[i]);
        }

        return nums;
    }

    public static void main(String[] args) {
        Arrays.stream(new LeetCode2574().leftRightDifference(new int[]{10, 4, 8, 3}))
                .forEach(System.out::println);
    }
}
