package LeetCodeMedium;

import java.util.Arrays;

public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k%l;
        int a = 0;
        int b = l-1;
        while(a<b){
            int temp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = temp;
        }
        a = 0;
        b = k-1;
        while(a<b){
            int temp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = temp;
        }
        a = k;
        b = l-1;
        while(a<b){
            int temp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println("Array -> "+ Arrays.toString(arr));
        int k = 4;
        Leetcode189 obj = new Leetcode189();
        obj.rotate(arr,k);
        System.out.println("Array after rotating -> "+ Arrays.toString(arr));

    }

}
