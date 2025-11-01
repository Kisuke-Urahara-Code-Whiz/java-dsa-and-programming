package LeetCodeEasy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        sums.add(n);
        int a = n;
        int s = 0;
        while(a>0){
            s = s+(int)Math.pow((a%10),2);
            a = a/10;
        }
        return rec(sums,s);
    }

    public boolean rec(Set<Integer> sums, int nextSum){
        if(nextSum==1)
            return true;
        else if(sums.contains(nextSum))
            return false;
        else{
            sums.add(nextSum);
            int a = nextSum;
            int s = 0;
            while(a>0){
                s = s+(int)Math.pow((a%10),2);
                a = a/10;
            }
            return false || rec(sums,s);
        }
    }

    public static void main(String[] args) {
        LeetCode202 obj = new LeetCode202();
        System.out.println("Happy Number -> "+obj.isHappy(19));
    }

}
