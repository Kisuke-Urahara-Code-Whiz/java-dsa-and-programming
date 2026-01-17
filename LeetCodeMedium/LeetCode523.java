package LeetCodeMedium;

import java.util.*;

//Prefix Sum equation -> nums[j]-nums[i-1]=desired value of k
//This equation is the key to solving the whole question here and almost all prefix sum questions
public class LeetCode523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = currentSum % k;

            if (map.containsKey(remainder)) {
                int previousIndex = map.get(remainder);
                if (i - previousIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    static void main() {
        int result = 0;
        List<List<Integer>> arrays =List.of(
                List.of(23, 2, 4, 6, 7),
                List.of(23, 2, 6, 4, 7),
                List.of(23, 2, 6, 4, 7),
                List.of(0, 0),
                List.of(5,0,0),
                List.of(1,0),
                List.of(0),
                List.of(6),
                List.of(1,5),
                List.of(5,2,4),
                List.of(1,2,3),
                List.of(1,1),
                List.of(23,2,4,6,6));

        List<Integer> ks = List.of(6,6,13,5,3,2,5,6,6,5,5,1,7);
        List<Boolean> answers = List.of(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE,
                 Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
        for(int i=0;i<arrays.size();i++){
            int[] arr = new int[arrays.get(i).size()];
            for(int j=0;j<arr.length;j++){
                arr[j] = arrays.get(i).get(j);
            }
            String correct = new LeetCode523().checkSubarraySum(arr,ks.get(i))==answers.get(i)?"Correct Answer":"Incorrect Answer";
            result = correct.equals("Correct Answer")?result+=1:result;
            if(correct.equals("Incorrect Answer"))
                System.out.println(i+1+") "+arrays.get(i)+", k = "+ks.get(i)+", Answer = "+answers.get(i)+", "+correct);
        }
        System.out.println("Correct Answers -> "+result+"/"+arrays.size());
    }


}
