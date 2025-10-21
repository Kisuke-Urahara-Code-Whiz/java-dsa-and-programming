package LeetCodeMedium;

import Programs.ListNode;

import java.util.Arrays;

public class LeetCode1019 extends ListNode {

    int[] arr;
    ListNode max;

    public int[] nextLargerNodes(ListNode head) {
        find(head,head.next,1);
        return arr;
    }

    public void find(ListNode prev, ListNode curr, int l){
        if(curr==null){
            max = prev;
            arr = new int[l];
            arr[l-1] = 0;
        } else {
            find(curr,curr.next,l+1);
            if(max.val>prev.val){
                arr[l-1] = max.val;
            } else {
                max = prev;
                arr[l-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1019 obj = new LeetCode1019();
        int[] arr = new int[]{2,1,5};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Resultant Array -> "+ Arrays.toString(obj.nextLargerNodes(head)));
    }
}
