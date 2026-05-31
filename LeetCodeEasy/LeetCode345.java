package LeetCodeEasy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode345 {
    public String reverseVowels(String s) {
        if(s.length()==1) return s;
        Set<Integer> set = new HashSet<>();
        for(int i: new int[]{65, 69, 73, 79, 85}){
            set.add(i);
            set.add(i+32);
        }
        char[] c = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = c.length-1;
        while(ptr1<=ptr2){
            while(ptr1<c.length && !set.contains((int)c[ptr1])){
                ptr1++;
            }
            while(ptr2>=0 && !set.contains((int)c[ptr2])){
                ptr2--;
            }
            if(ptr1<=ptr2){
                char temp = c[ptr1];
                c[ptr1++] = c[ptr2];
                c[ptr2--] = temp;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode345().reverseVowels(",."));
    }
}
