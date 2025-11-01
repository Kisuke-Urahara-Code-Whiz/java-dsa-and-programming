package LeetCodeEasy;

public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        char[] ch = s.toCharArray();
        int l = ch.length-1;
        int length = 0;
        while(l>-1 && ch[l]==' '){
            l-=1;
        }
        while(l>-1 && ch[l]!=' '){
            length+=1;
            l-=1;
        }
        return length;
    }

}
