package LeetCodeEasy;

import java.util.HashSet;

public class LeetCode2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int i: nums){
            set.add(i);
        }
        for(int i: nums){
            if(set.contains(i+diff) && set.contains(i+diff*2)) result+=1;
        }
        return result;
    }

}
