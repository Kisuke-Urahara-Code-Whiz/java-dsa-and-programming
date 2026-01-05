package LeetCodeEasy;

import java.util.*;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hs = new HashSet<>();

        for(int k : nums1){
            hs.add(k);
        }
        List<Integer> result1 = new ArrayList<>();

        for(int p : nums2){
            if(hs.contains(p)){
                hs.remove(p);
                result1.add(p);
            }
        }

        int[] result = new int[result1.size()];
        int p = 0;
        for(int i = 0; i < result1.size(); i++){
            result[p] = result1.get(i);
            p++;
        }
        return result;
    }

    static void main() {
        System.out.println(Arrays.toString(new LeetCode349().intersection(
                new int[]{1,2,2,1},
                new int[]{2,2})));
    }
}
