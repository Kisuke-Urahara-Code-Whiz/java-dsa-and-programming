package LeetCodeMedium;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        while(i<temperatures.length){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                temperatures[index] = i-index;
            }
            stack.push(i);
            i+=1;
        }
        while(!stack.isEmpty()){
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }

    public static void main(String[] args) {
        LeetCode739 obj = new LeetCode739();
        System.out.println("Daily Temperatures -> "+ Arrays.toString(obj.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
