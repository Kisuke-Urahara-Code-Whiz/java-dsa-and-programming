package LeetCodeHard;

import Programs.ListNode;

public class LeetCode25 extends ListNode{

    ListNode gprev;
    ListNode last;

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        gprev = res;
        gprev.next = head;
        boolean flag = false;
        do{
            flag = reversal(gprev, gprev.next, k);
        } while(flag);
        return res.next;
    }

    public boolean reversal(ListNode prev, ListNode curr, int n){
        if(curr==null && n!=0)
            return false;
        else if(n==0){
            gprev.next = prev;
            last = curr;
            return true;
        }
        else{
            boolean flag = reversal(curr, curr.next, n-1);
            if(flag){
                if(prev==gprev) {
                    curr.next = last;
                    gprev = curr;
                }
                else{
                    curr.next = prev;
                    curr.next.next = null;
                }
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode25 obj = new LeetCode25();
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int n = 5;
        head = obj.reverseKGroup(head, n);
        System.out.println("Reversing Linked List by "+n+" terms -> ");
        obj.displayLinkedList(head);
    }

}
