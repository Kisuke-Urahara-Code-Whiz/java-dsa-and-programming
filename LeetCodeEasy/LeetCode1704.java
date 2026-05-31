package LeetCodeEasy;
import java.util.Set;

public class LeetCode1704 {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = Set.of('A','E','I','O','U','a','e','i','o','u');
        char[] c = s.toCharArray();
        int p1 = 0;
        int p2 = c.length/2;
        int v1 = 0;
        int v2 = 0;
        while(p2!=c.length){
            v1 = set.contains(c[p1++])? v1+1 : v1;
            v2 = set.contains(c[p2++])? v2+1 : v2;
        }
        return v1==v2;
    }

}
