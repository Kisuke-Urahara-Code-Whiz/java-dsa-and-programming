package LeetCodeHard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This solution -> not the optimal solution
// TC -> O(n*3^n-1)
// Doesnt hold multi digit concatenation and I don't understand it

public class LeetCode282 {

    List<String> arr = new ArrayList<>();
    char[] ops = new char[]{'+','-','*'};
    Stack<Character> oprstack = new Stack<>();
    Stack<Integer> opdstack = new Stack<>();

    int precedence(char ops){
        if(ops=='+' || ops=='-')
            return 1;
        return 2;
    }

    int operation(int a, int b, char ops){
        int res = 0;
        switch(ops){
            case '+': res = a+b;
                break;

            case '-': res = a-b;
                break;

            case '*': res = a*b;
                break;
        }
        return res;
    }

    void oprs(char op) {
        if (!(opdstack.size() < 2)) {
            int a = opdstack.pop();
            int b = opdstack.pop();
            int c = 0;
            boolean flag = op=='+' || op=='-';
            if(!(oprstack.isEmpty()) && oprstack.peek()=='-' && flag){
                oprstack.pop();
                b = b*-1;
                c = 1;
            }
            int res = operation(b,a,op);
            if(opdstack.isEmpty())
                opdstack.push(res);
            else{
                if(c==0)
                    opdstack.push(res);
                else{
                    if(res<0){
                        opdstack.push(res*-1);
                        oprstack.push('-');
                    }
                    else{
                        opdstack.push(res);
                        oprstack.push('+');
                    }
                }
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        int l = num.length();
        int p = 0;
        if(num.lastIndexOf('0')!=num.length()-1) {
            while (num.charAt(p) == '0') {
                p += 1;
            }
        }
        char[] nums = num.substring(p).toCharArray();
        char[] exp = new char[(nums.length*2)-1];
        backtrack(nums, exp, 0,0 ,target);
        return arr;
    }

    public void backtrack(char[] nums, char[] exp, int p1, int p2, int target){
        if(p1>=nums.length){
            opdstack.clear();
            oprstack.clear();
            infixEval(exp, 0);
            int res = opdstack.pop();
            if(res == target)
                arr.add(new String(exp));
        }
        else{
            exp[p2] = nums[p1];
            p2+=1;
            if(p2<exp.length) {
                for (int i = 0; i < 3; i++) {
                    exp[p2] = ops[i];
                    backtrack(nums, exp, p1 + 1, p2 + 1, target);
                    exp[p2] = ' ';
                }
            }
            else
                backtrack(nums, exp, p1 + 1, p2 + 1, target);
            p2 -= 1;
            exp[p2] = ' ';
        }
    }

    void infixEval(char[] exp, int p){
        if(p<exp.length){
            if(Character.isDigit(exp[p]))
                opdstack.push((int) (exp[p] - '0'));
            else{
                if(oprstack.isEmpty())
                    oprstack.push(exp[p]);
                else{
                    char prev = oprstack.peek();
                    if(precedence(exp[p])<precedence(prev)){
                        while((precedence(exp[p])<precedence(prev)) && !(oprstack.isEmpty())){
                            oprs(oprstack.pop());
                            if(!(oprstack.isEmpty()))
                                prev = oprstack.peek();
                        }
                        oprstack.push(exp[p]);
                    }
                    else{
                        oprstack.push(exp[p]);
                    }
                }
            }
            infixEval(exp,p+1);
            if(!oprstack.isEmpty()){
                oprs(oprstack.pop());
            }
        }
    }

    public static void main(String[] args) {
        String num = "00";
        System.out.println("String -> "+num);
        LeetCode282 obj = new LeetCode282();
        obj.addOperators(num, 0);
        System.out.println("Possible Combinations achieving target -> \n"+obj.arr);
    }
}