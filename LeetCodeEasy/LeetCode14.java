package LeetCodeEasy;

public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        int p = 0;
        if(strs.length==1)
            return strs[0];
        int len = strs.length;
        int index = 0;
        int c = 0;
        int l = 201;
        for(String i:strs){
            if(i.isEmpty())
                return new String("");
            if(strs[index].length()<l){
                l = strs[index].length();
                c = index;
            }
            index+=1;
        }
        char[] prefix = new char[strs[c].length()];
        index = 0;
        while(index< prefix.length){
            boolean flag = true;
            int len1 = 0;
            while(len1<len){
                if(strs[len1].charAt(index) != strs[c].charAt(index)) {
                    flag = false;
                    break;
                }
                len1+=1;
            }
            if(!flag)
                break;
            prefix[index] = strs[c].charAt(index);
            index+=1;
        }
        return new String(prefix).substring(0,index);
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flower","flow","flight"};
        LeetCode14 obj = new LeetCode14();
        System.out.println("Longest Common Prefix -> "+obj.longestCommonPrefix(str));
    }

}
