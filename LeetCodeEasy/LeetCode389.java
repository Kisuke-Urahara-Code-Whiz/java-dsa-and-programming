package LeetCodeEasy;

import java.util.HashMap;

public class LeetCode389 {

    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            if(freqMap.containsKey(c)) freqMap.put(c,freqMap.get(c)+1);
            else freqMap.put(c, 1);
        }
        for(char c: t.toCharArray()){
            if(freqMap.containsKey(c)){
                int f = freqMap.get(c);
                f-=1;
                if(f==-1) return c;
                freqMap.put(c, f);
            } else return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode389().findTheDifference("abcd", "abcde"));
    }

}
