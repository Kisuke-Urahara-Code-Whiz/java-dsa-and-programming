package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
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
            int[] nums
    ) {
        if(temp.size()==used.length) result.add(new ArrayList<>(temp));
        else{
            for(int i=0;i<used.length;i++){
                if(used[i]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtrack(result, temp, used, nums);
                temp.removeLast();
                used[i] = false;
            }
        }
    }

}
