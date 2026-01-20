package Programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrefixSumEqualToK {

    private int subarraySum(int[] nums, int k) {
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

    private List<List<Integer>> subarrays(int[] nums, int k){
        List<List<Integer>> result = new ArrayList<>();
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1] = nums[i]+prefixSum[i];
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,List<Integer>> indexMap= new HashMap<>();
        for(int i=0;i<prefixSum.length;i++){
            int needed = prefixSum[i] - k;
            if(freq.getOrDefault(needed,0)>0){
                List<Integer> indexes = indexMap.get(needed);
                for(Integer j:indexes){
                    List<Integer> sub = new ArrayList<>();
                    for(int x=j;x<i;x++){
                        sub.add(nums[x]);
                    }
                    result.add(sub);
                }
            }
            int newF = freq.getOrDefault(prefixSum[i],0)+1;
            if (newF > 1) indexMap.get(prefixSum[i]).add(i);
            else{
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                indexMap.put(prefixSum[i], indexes);
            }
            freq.put(prefixSum[i], newF);
        }
        return result;
    }

    static void main() {
        System.out.println(new PrefixSumEqualToK().subarrays(new int[]{1,2,3,0,0,4},0));
    }
}
