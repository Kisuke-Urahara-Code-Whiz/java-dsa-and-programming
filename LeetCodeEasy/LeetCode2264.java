package LeetCodeEasy;

public class LeetCode2264 {

    public String largestGoodInteger(String num) {
        int ptr1 = 0;
        int ptr2 = 1;
        int ptr3 = 2;
        char[] c = num.toCharArray();
        int max = -1;
        while(ptr3<num.length()){
            if(c[ptr1] == c[ptr2] && c[ptr2] == c[ptr3])
                max = max==-1 || c[ptr1]>max ? c[ptr1] : max;
            ptr1++;
            ptr2++;
            ptr3++;
        }
        if(max==-1) return "";
        return new String(new char[]{(char)max,(char)max,(char)max});
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2264().largestGoodInteger("42352338"));
    }

}
