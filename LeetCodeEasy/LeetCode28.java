package LeetCodeEasy;

public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        char[] c = haystack.toCharArray();
        char[] ch = needle.toCharArray();
        int a = 0;
        int b = 0;
        int index = -1;
        while(a<c.length && b<ch.length){
            if(c[a]==ch[b]){
                if(a==0)
                    index = a;
                a+=1;
            } else {
                a=0;
                index=-1;
            }
            b+=1;
        }
        return index;
    }

    public static void main(String[] args) {
        
    }

}
