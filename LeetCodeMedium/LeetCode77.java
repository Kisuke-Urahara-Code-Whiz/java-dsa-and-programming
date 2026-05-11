package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=1;i<=n;i++){
            temp.add(i);
            backtrack(result, temp, i+1,1, n, k);
            temp.removeLast();
        }
        return result;
    }

    private void backtrack(
            List<List<Integer>> result, List<Integer> temp, int loopPtr, int ptr, int n, int k
    ){
        if(ptr==k) result.add(new ArrayList<>(temp));
        else{
            for(int i=loopPtr;i<=n;i++){
                temp.add(i);
                backtrack(result, temp, i+1, ptr+1, n, k);
                temp.removeLast();
            }
        }
    }

}
