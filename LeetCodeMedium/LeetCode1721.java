package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode1721 extends ListNode {

    ListNode f;
    ListNode l;

    public ListNode swapNodes(ListNode head, int k) {
        ListNode res = new ListNode(0,head);
        return res.next;
    }


    public static void main(String[] args) {
        LeetCode1721 obj = new LeetCode1721();
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int n = 4;
        head = obj.swapNodes(head, n);
        System.out.println("Linked List after swapping -> ");
        obj.displayLinkedList(head);
    }
}
