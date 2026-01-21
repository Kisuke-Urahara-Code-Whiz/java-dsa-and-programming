package LeetCodeMedium;

import java.util.HashMap;

public class LeetCode974 {

    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            int rem = (prefixSum % k + k) % k;
            result += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return result;
    }

    static void main() {
        System.out.println(new LeetCode974().subarraysDivByK(new int[]{-1,2,9},2));
    }
}
