package LeetCodeMedium;

import java.util.Stack;

public class LeetCode2390 {

    static class Stack {

        char[] stack;
        int top;

        Stack(int n){
            stack = new char[n];
            top = -1;
        }

        public char peek(){
            return top==-1?' ':stack[top];
        }

        public boolean isEmpty(){
            return top==-1;
        }

        public void push(char c){
            stack[++top] = c;
        }

        public char pop(){
            return stack[top--];
        }

        public void poll(){
            top = top-1;
        }
    }

    public String removeStars(String s) {
        Stack stack = new Stack(s.length());
        int ptr = s.length()-1;
        for(int i=ptr;i>=0;i--){
            if(stack.peek()=='*' && s.charAt(i)!='*') stack.poll();
            else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2390().removeStars("erase*****"));
    }

}
