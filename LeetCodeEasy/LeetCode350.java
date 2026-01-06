package LeetCodeEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode350 {

    Map<Integer,Integer> map = new HashMap<>();

    public int[] intersect(int[] nums1, int[] nums2) {
        for(int i:nums1){
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i,1);
        }

        List<Integer> list = new ArrayList<>();

        for(int j:nums2){
            if(map.containsKey(j) && map.get(j)>0) {
                map.put(j, map.get(j) - 1);
                list.add(j);
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }

}

// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
