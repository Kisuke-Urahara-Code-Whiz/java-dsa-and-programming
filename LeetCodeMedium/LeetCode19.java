package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        int c = remove(res, head, n);
        return res.next;
    }

    public int remove(ListNode prev, ListNode current, int n){
        if(current!=null){
            n = remove(current, current.next, n);
            if(n==1)
                prev.next = current.next;
            return n-1;
        } else
            return n;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2};
        ListNode obj = new ListNode();
        ListNode head = obj.createLinkedList(arr);
        System.out.print("Linked List : ");
        obj.displayLinkedList(head);

        LeetCode19 sc = new LeetCode19();
        head = sc.removeNthFromEnd(head,1);
        System.out.print("Linked List after removing a Node : ");
        obj.displayLinkedList(head);

    }

}
