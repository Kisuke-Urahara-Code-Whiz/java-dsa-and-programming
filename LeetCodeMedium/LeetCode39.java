package LeetCodeMedium;

import java.util.*;

public class LeetCode39 {

    List<List<Integer>> result= new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<candidates.length;i++){
            combination(candidates, target, list, i, candidates.length, 0);
        }
        return  result;
    }

    public void combination(int[] candidates, int target, List<Integer> list, int start, int end, int sum){
        if(start<candidates.length && candidates[start]+sum<=target){
            sum+=candidates[start];
            list.add(candidates[start]);
            if(sum == target)
                result.add(new ArrayList<>(list));
            else {
                for(int i=start;i<=end;i++){
                    combination(candidates, target, list, i, end, sum);
                }
            }
            list.removeLast();
        }
    }

}
