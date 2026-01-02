package LeetCodeMedium;

import java.util.*;

public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result, temp, used, nums);
        return result;
    }

    private void backtrack(
            List<List<Integer>> result,
            List<Integer> temp,
            boolean[] used,
            int[] arr
    ){
        if(used.length==temp.size()) result.add(new ArrayList<>(temp));
        else{
            for(int i=0;i<used.length;i++){
                if(used[i]) continue;
                if(i>0 && arr[i-1]==arr[i] && !used[i-1]) continue;
                temp.add(arr[i]);
                used[i] = true;
                backtrack(result, temp, used, arr);
                temp.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode47().permuteUnique(new int[]{1,2,2}));
    }
}
