package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode1669 extends ListNode {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        int[] arr2 = {1000000,1000001,1000002,1000003,1000004};
        LeetCode1669 obj = new LeetCode1669();
        ListNode head = obj.createLinkedList(arr);
        ListNode head2 = obj.createLinkedList(arr2);
        obj.displayLinkedList(obj.mergeInBetween(head,2,5,head2));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode(0,list1);
        b = b-a;
        list1 = res;
        ListNode p1;
        ListNode p2;
        while(a!=0 && list1!=null){
            a-=1;
            list1 = list1.next;
        }
        p1 = list1.next;
        list1.next = list2;
        while(list1.next!=null){
            list1 = list1.next;
        }
        while(b!=0){
            p1 = p1.next;
            b-=1;
        }
        list1.next = p1.next;
        return res.next;
    }
}
