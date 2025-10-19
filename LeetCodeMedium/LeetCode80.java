package LeetCodeMedium;

import LeetCodeEasy.LeetCode26;

import java.util.Arrays;

public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int a = 0;
        int b = -101;
        int c = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==b && c==1){
                if(a!=i)
                    nums[a] = nums[i];
                a+=1;
                sum+=1;
                c+=1;
            } else if(nums[i]!=b){
                b = nums[i];
                if(a!=i)
                    nums[a] = nums[i];
                a+=1;
                sum+=1;
                c=1;
            } else {
                b = nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode80 obj = new LeetCode80();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Array -> "+ Arrays.toString(nums));
        System.out.println("Length of double uniqueness -> "+ obj.removeDuplicates(nums)+"\nArray -> "+ Arrays.toString(nums));
    }

}
