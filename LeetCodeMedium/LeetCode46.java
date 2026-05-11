package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
            used[i] = true;
            backtrack(result, temp, used, nums, 1, nums.length);
            used[i] = false;
            temp.removeLast();
        }
        return result;
    }

    private void backtrack(
            List<List<Integer>> result, List<Integer> temp, boolean[] used, int[] nums, int ptr, int length
    ){
        if(ptr==length) result.add(new ArrayList<>(temp));
        else{
            for(int i=0;i<length;i++){
                if(!used[i]){
                    temp.add(nums[i]);
                    used[i] = true;
                    backtrack(result, temp, used, nums, ptr+1, length);
                    used[i] = false;
                    temp.removeLast();
                }
            }
        }
    }

}
