package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
            combinations(i+1,n,k-1,list);
            list.removeLast();
        }
        return result;
    }

    private void combinations(int start, int end, int count, List<Integer> list){
        if(count!=0) {
            for (int i = start; i <= end; i++) {
                list.add(i);
                combinations(i+1,end,count-1,list);
                list.removeLast();
            }
        } else {
            result.add(new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        LeetCode77 obj = new LeetCode77();
        System.out.println("Result -> " + obj.combine(3,3));
    }

}
