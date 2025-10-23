package LeetCodeEasy;

public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        int l = needle.length();
        int a = 0;
        while(a+l<=haystack.length()){
            if(needle.equals(haystack.substring(a,a+l))){
                return a;
            } else
                a+=1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        System.out.println("Index -> "+new LeetCode28().strStr(haystack, needle));
    }

}
