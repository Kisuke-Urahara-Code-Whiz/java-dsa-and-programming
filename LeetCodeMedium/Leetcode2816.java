package LeetCodeMedium;

import Programs.ListNode;

public class Leetcode2816 extends ListNode {

    public ListNode doubleIt(ListNode head) {
        int n = traversal(head);
        if(n>0){
            head = new ListNode(n,head);
        }
        return head;
    }

    public int traversal(ListNode curr){
        if(curr==null)
            return 0;
        else{
            int carry = traversal(curr.next);
            int prod = (curr.val*2)+carry;
            curr.val = prod%10;
            return prod/10;
        }
    }
}
