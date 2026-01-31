package LeetCodeMedium;

import java.util.HashMap;

public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1] = nums[i]+prefixSum[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<prefixSum.length;i++){
            int needed = prefixSum[i] - k;
            result+=map.getOrDefault(needed,0);
            map.put(prefixSum[i],map.getOrDefault(prefixSum[i],0)+1);
        }
        return result;
    }

}
