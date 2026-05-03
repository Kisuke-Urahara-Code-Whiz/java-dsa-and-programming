package LeetCodeMedium;

import java.util.HashSet;

public class LeetCode128 {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> exist = new HashSet<>();
        int result = 0;

        for(int i: nums){
            exist.add(i);
        }

        for(int i: exist){
            if(!exist.contains(i-1)){
                int current = i;
                int combination = 0;
                while(exist.contains(current)){
                    combination+=1;
                    current = current+1;
                }
                result = Math.max(result, combination);
            }
        }

        return result;
    }

//    O(N) too
//    public int longestConsecutive(int[] nums) {
//
//        HashSet<Integer> exist = new HashSet<>();
//        HashMap<Integer, Boolean> used = new HashMap<>();
//        int result = 0;
//
//        for(int i: nums){
//            exist.add(i);
//            used.put(i, Boolean.FALSE);
//        }
//
//        for(int i: nums){
//            if(!used.get(i)){
//                int current = i;
//                while(true){
//                    if(exist.contains(current-1)) current = current-1;
//                    else break;
//                }
//                int combination = 0;
//                while(exist.contains(current)){
//                    combination+=1;
//                    used.put(current, Boolean.TRUE);
//                    current = current+1;
//                }
//                result = Math.max(result, combination);
//            }
//        }
//
//        return result;
//    }

}
