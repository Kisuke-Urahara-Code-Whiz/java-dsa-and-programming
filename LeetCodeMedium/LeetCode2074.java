package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode2074 extends ListNode {

    ListNode gprev;

    public ListNode reverseEvenLengthGroups(ListNode head) {
        gprev = head;
        int l;
        int g = 2;
        int a;
        do{
            a = g;
            l = 0;
            l = reversal(gprev, gprev.next, g, l+1);
            g+=1;
        } while(l==a);
        return head;
    }

    public int reversal(ListNode prev, ListNode curr, int g, int l){
        if(g<l || curr==null) {
            return l - 1;
        }
        else{
            int a = l;
            l = reversal(curr, curr.next, g, l+1);
            if(l%2==0){
                if(a==l) {
                    gprev.next.next = curr.next;
                    gprev.next = curr;
                    curr.next = prev;
                } else if (a==1) {
                    gprev = curr;
                } else
                    curr.next = prev;
            } else {
                if(a==l)
                    gprev = curr;
            }
            return l;
        }
    }

    public static void main(String[] args) {
        LeetCode2074 obj = new LeetCode2074();
        int[] arr = new int[]{5,2,6,3,9,1,7,3,8,4};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        head = obj.reverseEvenLengthGroups(head);
        System.out.println("Linked List after reversing even length groups -> ");
        obj.displayLinkedList(head);
    }

}
