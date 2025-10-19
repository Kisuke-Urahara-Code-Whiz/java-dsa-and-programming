package LeetCodeEasy;

import java.util.Arrays;

public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int a = 0;
        int b = -101;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=b) {
                b = nums[i];
                sum += 1;
                if (a != i) {
                    nums[a] = nums[i];
                    nums[i] = -101;
                }
                a += 1;
            }
            else
                b = nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode26 obj = new LeetCode26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Array -> "+ Arrays.toString(nums));
        System.out.println("Length of uniqueness -> "+ obj.removeDuplicates(nums)+"\nArray -> "+ Arrays.toString(nums));
    }

}
