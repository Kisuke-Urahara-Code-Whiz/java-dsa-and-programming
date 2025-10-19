package LeetCodeEasy;

import java.util.Arrays;

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int a = (m+n)-1;
        while(a>=0){
            if(p1>=0 && p2>=0){
                if(nums1[p1]>nums2[p2])
                    nums1[a--] = nums1[p1--];
                else
                    nums1[a--] = nums2[p2--];
            } else {
                if (p1 >=0)
                    nums1[a--] = nums1[p1--];
                if (p2 >=0)
                    nums1[a--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        LeetCode88 obj = new LeetCode88();
        int[] nums1 = {1};
        int[] nums2 = {};
        obj.merge(nums1,1,nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
