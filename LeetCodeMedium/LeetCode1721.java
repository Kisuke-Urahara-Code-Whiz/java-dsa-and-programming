package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode1721 extends ListNode {

    ListNode f;
    ListNode l;

    public ListNode swapNodes(ListNode head, int k) {
        ListNode res = new ListNode(0,head);
        if(head.next == null)
            return head;
        rec(null, res , k, 0);
        if(f==l.next || l==f.next)
            sideSwap();
        else
            swap();
        return res.next;
    }

    public void sideSwap(){
        if(f==l.next){
            ListNode temp = l;
            l = f;
            f = temp;
        }
        f.next = l.next;
        l.next = f.next.next;
        f.next.next = l;
    }

    public void swap(){
        ListNode temp1 = f.next;
        ListNode temp2 = f.next.next;
        f.next.next = l.next.next;
        l.next.next = temp2;
        f.next = l.next;
        l.next = temp1;
    }

    public int rec(ListNode prev, ListNode curr, int n, int p){
        if(curr==null)
            return 1;
        else{
            if(p+1==n)
                f=curr;
            p = rec(curr, curr.next, n, p+1);
            if(p-1==n)
                l=curr;
            return p+1;
        }
    }


    public static void main(String[] args) {
        LeetCode1721 obj = new LeetCode1721();
        int[] arr = new int[]{7,9,6,6,7,8,3,0,9,5};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int n = 5;
        head = obj.swapNodes(head, n);
        System.out.println("Linked List after swapping -> ");
        obj.displayLinkedList(head);
    }
}
