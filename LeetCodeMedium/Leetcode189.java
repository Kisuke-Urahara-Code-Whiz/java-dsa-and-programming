package LeetCodeMedium;

import java.util.Arrays;

public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        if(nums.length!=1){
            k = k%nums.length;
            reverse(0, nums.length-1, nums);
            reverse(0, k-1, nums);
            reverse(k, nums.length-1, nums);
        }
    }

    private void reverse(int p1, int p2, int[] nums){
        while(p1<p2){
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1+=1;
            p2-=1;
        }
    }

}
