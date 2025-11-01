package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode147 extends ListNode {

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        LeetCode147 obj = new LeetCode147();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after insertion sort -> ");
        head = obj.insertionSortList(head);
        obj.displayLinkedList(head);
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0,head);
        ListNode p = null;
        do{
            ListNode prev = res;
            ListNode curr = res.next;
            while(curr.next!=p){
                if(curr.next.val< curr.val){
                    prev.next = curr.next;
                    curr.next = prev.next.next;
                    prev.next.next = curr;
                    prev = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            p = curr;
        } while(p!=res.next);
        return res.next;
    }
}
