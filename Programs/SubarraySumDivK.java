package Programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumDivK {

    private List<List<Integer>> subarrays(int[] nums, int k){
        List<List<Integer>> result = new ArrayList<>();
        int prefixSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        freq.put(0,1);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        indexMap.put(0,list);
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int remainder = prefixSum%k<0? (prefixSum%k+k)%k: prefixSum%k;
            if(freq.getOrDefault(remainder,0)>0){
                for(Integer j:indexMap.get(remainder)){
                    List<Integer> subarray = new ArrayList<>();
                    for(int x=j;x<=i;x++){
                        subarray.add(nums[x]);
                    }
                    result.add(subarray);
                }
                indexMap.get(remainder).add(i+1);
            }
            else{
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i+1);
                indexMap.put(remainder,indexes);
            }
            freq.put(remainder,freq.getOrDefault(remainder,0)+1);
        }
        return result;
    }
}
