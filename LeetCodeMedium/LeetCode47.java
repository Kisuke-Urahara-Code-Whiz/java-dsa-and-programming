package LeetCodeMedium;

import java.util.*;

public class LeetCode47 {

    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> unique = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] processed = new int[nums.length];
        int a = 0;
        permute(processed, nums, a);
        return result;
    }

    public void permute(int[] processed, int[] unprocessed, int a){
        if(a<processed.length){
            for(int i=0;i<unprocessed.length;i++){
                processed[a] = unprocessed[i];
                permute(processed,makeUnprocessed(unprocessed,i),a+1);
            }
        }
        else{
            List<Integer> list = new ArrayList<>();
            for (int n : processed) {
                list.add(n);
            }
            if(!unique.contains(list)){
                result.add(list);
                unique.add(list);
            }
        }
    }

    public int[] makeUnprocessed(int[] unprocessed, int k){
        int[] newUnprocessed = new int[unprocessed.length-1];
        int index = 0;
        for(int i=0;i<unprocessed.length;i++){
            if(i!=k)
                newUnprocessed[index++] = unprocessed[i];
        }
        return newUnprocessed;
    }

    public static void main(String[] args) {
        LeetCode47 obj = new LeetCode47();
        int[] arr = new int[]{1,1,2};
        System.out.println("The Original Array -> \n"+Arrays.toString(arr));
        System.out.println("Unique Permutations -> ");
        obj.permuteUnique(arr);
        System.out.println(obj.result);
    }

}
