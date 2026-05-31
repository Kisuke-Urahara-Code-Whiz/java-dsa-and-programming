package LeetCodeMedium;

public class LeetCode155 {

    static class MinStack {

        int[] stack;
        int[] minStack;
        int top;
        int min;

        public MinStack() {
            stack = new int[40000];
            minStack = new int[40000];
            top = 0;
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            min = top==0? val: Math.min(val, min);
            top+=1;
            stack[top] = val;
            minStack[top] = min;
        }

        public void pop() {
            top-=1;
            min = top==0? min : getMin();
        }

        public int top() {
            return stack[top];
        }

        public int getMin() {
            return minStack[top];
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        String[] instructions = new String[]{
                "MinStack",
                "push",
                "push",
                "push",
                "getMin",
                "pop",
                "getMin",
                "pop",
                "getMin",
                "pop",
                "push",
                "push",
                "push",
                "getMin",
                "pop",
                "top",
                "getMin",
                "pop",
                "getMin",
                "pop"
        };

        int[][] params = new int[][]{
                {},     // MinStack
                {-2},   // push(-2)
                {0},    // push(0)
                {-1},   // push(-1)
                {},     // getMin
                {},     // pop
                {},     // getMin
                {},     // pop
                {},     // getMin
                {},     // pop
                {-2},   // push(-2)
                {-1},   // push(-1)
                {-2},   // push(-2)
                {},     // getMin
                {},     // pop
                {},     // top
                {},     // getMin
                {},     // pop
                {},     // getMin
                {}      // pop
        };
        for(int i=0;i<instructions.length;i++){
            if(instructions[i].equals("push")) stack.push(params[i][0]);
            else if(instructions[i].equals("pop")) stack.pop();
            else if(instructions[i].equals("getMin")) System.out.println("Minimum -> "+stack.getMin());
            else System.out.println("Top Element -> "+stack.top());

        }
    }

}
