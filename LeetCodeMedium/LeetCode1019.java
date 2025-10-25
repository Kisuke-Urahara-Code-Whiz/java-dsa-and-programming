package LeetCodeMedium;

import Programs.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LeetCode1019 extends ListNode {

    int[] arr;
    int max;
    int nMax;
    Stack<Integer> stack = new Stack<>();

    public int[] nextLargerNodes(ListNode head) {
        find(head,0);
        return arr;
    }

    public void find(ListNode curr, int l){
        if(curr == null){
            arr = new int[l];
        } else {
            find(curr.next, l+1);
            if(curr.next == null){
                arr[l] = 0;
                stack.push(curr.val);
            } else {
                while(!stack.isEmpty() && curr.val>=stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    arr[l] = stack.peek();
                    stack.push(curr.val);
                } else {
                    arr[l] = 0;
                    stack.push(curr.val);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1019 obj = new LeetCode1019();
        int[] arr = new int[]{9,7,6,7,6,9};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Resultant Array -> "+ Arrays.toString(obj.nextLargerNodes(head)));
    }
}
