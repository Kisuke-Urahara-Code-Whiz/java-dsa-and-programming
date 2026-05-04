package LeetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int i:candies){
            if(i>max) max = i;
        }
        for(int i=0;i<candies.length;i++){
            result.add((candies[i]+extraCandies)>=max);
        }
        return result;
    }
}
