package LeetCodeMedium;

import java.util.HashMap;
import java.util.Map;

//If your total rope length is 20 meters (currentSum), and you want to cut off a piece at the end that is 7 meters long (k), where must the cut start?
//
//It must start at the 13 meter mark (20 - 7).
//
//The Question becomes: "Did I verify a rope length of 13 meters earlier?" If you recorded a prefix sum of 13 earlier in your map, it means you can effectively "cut" the rope there, and the remaining segment will be exactly 7.

public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<prefixSum.length;i++){
            int needed = prefixSum[i] - k;
            int freq = map.getOrDefault(needed, 0);
            count+=freq;
            int newF = map.getOrDefault(prefixSum[i],0)+1;
            map.put(prefixSum[i], newF);
        }
        return count;
    }

    static void main() {
        System.out.println(new LeetCode560().subarraySum(new int[]{1,1,1},2));
    }

}
