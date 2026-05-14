package LeetCodeMedium;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode735 {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {

            if (a > 0) st.push(a);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) st.push(a);
                else if (st.peek() == -a) st.pop();
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode735().asteroidCollision(new int[]{5,10,-5})));
    }

}
