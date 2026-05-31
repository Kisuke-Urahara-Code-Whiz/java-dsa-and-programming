package LeetCodeMedium;

import java.util.Arrays;

// Rotate Array - Partition and Reverse or Reverse and Partition too

public class Leetcode189 {

    // Partition and Reverse
    public void rotate(int[] nums, int k) {
        if(nums.length!=1){
            k = k%nums.length;
            if(k!=0){
                reverse(nums, 0, nums.length-k-1);
                reverse(nums, nums.length-k, nums.length-1);
                reverse(nums, 0, nums.length-1);
            }
        }
    }

    // Reverse and Partition
    public void newRotate(int[] nums, int k) {
        if(nums.length!=1){
            k = k%nums.length;
            if(k!=0){
                reverse(nums, 0, nums.length-1);
                reverse(nums, 0, k-1);
                reverse(nums, k, nums.length-1);
            }
        }
    }

    public void reverse(int[] arr, int l, int r){
        while(l<r){
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void main(String[] args) {
        Leetcode189 obj = new Leetcode189();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        obj.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

    }

}
