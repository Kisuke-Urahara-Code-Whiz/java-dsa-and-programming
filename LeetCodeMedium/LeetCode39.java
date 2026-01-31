package LeetCodeMedium;

import java.util.*;

public class LeetCode39 {

    List<List<Integer>> result= new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]>target) continue;
            list.add(candidates[i]);
            sum(list, candidates, target-candidates[i], i);
            list.removeLast();
        }
        return  result;
    }

    public void sum(List<Integer> temp, int[] candidates, int target, int index){
        if(target==0) result.add(new ArrayList<>(temp));
        else{
            for(int i=index;i<candidates.length;i++){
                if(candidates[i]>target) continue;
                temp.add(candidates[i]);
                sum(temp, candidates, target-candidates[i], i);
                temp.removeLast();
            }
        }
    }

}
