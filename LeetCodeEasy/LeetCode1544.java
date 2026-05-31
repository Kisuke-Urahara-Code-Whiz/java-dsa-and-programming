package LeetCodeEasy;

import java.util.Stack;

public class LeetCode1544 {

    public String makeGood(String s) {
        if(s.length()==1) return s;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(stack.isEmpty()) stack.add(c);
            else if((stack.peek()-c)!=32 && (stack.peek()-c)!=-32) stack.add(c);
            else stack.pop();
        }
        if(stack.isEmpty()) return "";
        char[] c  = new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            c[i] = stack.pop();
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1544().makeGood("aAbBcC"));
    }

}
