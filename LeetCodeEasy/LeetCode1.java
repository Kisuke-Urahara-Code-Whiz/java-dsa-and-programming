package LeetCodeEasy;

import java.util.HashMap;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(indexMap.containsKey(target-nums[i])) return new int[]{i, indexMap.get(target-nums[i])};
            else indexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
