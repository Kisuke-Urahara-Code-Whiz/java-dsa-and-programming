package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode1721 extends ListNode {

    ListNode f;
    ListNode l;

    public ListNode swapNodes(ListNode head, int k) {
        ListNode res = new ListNode(0,head);
        int a = swap(res, res.next,k, 1);
        return res.next;
    }

    public int swap(ListNode prev, ListNode curr, int n, int p){
        if(curr==null)
            return 1;
        else{
            boolean flag = false;
            if(p==n){
                f = curr;
                flag = true;
            }
            p = swap(curr,curr.next,n,p+1);
            if(p==n) {
                l = curr;
                ListNode temp = f.next;
                f.next = l.next;
                if (l != temp) {
                    l.next = temp;
                    prev.next = f;
                } else
                    l.next = f;
            }
            if(flag)
                prev.next = l;
            return p+1;
        }
    }

    public static void main(String[] args) {
        LeetCode1721 obj = new LeetCode1721();
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int n = 5;
        head = obj.swapNodes(head, n);
        System.out.println("Linked List after swapping -> ");
        obj.displayLinkedList(head);
    }
}
