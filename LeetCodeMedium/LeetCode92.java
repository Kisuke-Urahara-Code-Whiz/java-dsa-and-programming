package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode92 extends ListNode {

    ListNode r;
    ListNode l;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        reversal(null, res, 0, left, right);
        return res.next;
    }

    public void reversal(ListNode prev, ListNode curr, int c, int left, int right){
        if(c-1<=right){
            if(c-1==right){
                r = curr;
                l = prev;
                return;
            }
            reversal(curr,curr.next,c+1,left,right);
            if(c>left && c<=right){
                curr.next = prev;
                prev.next = null;
            } else if(c==left){
                 curr.next = r;
                 prev.next = l;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        LeetCode92 obj = new LeetCode92();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after reversal -> ");
        head = obj.reverseBetween(head,3,3);
        obj.displayLinkedList(head);
    }
}
