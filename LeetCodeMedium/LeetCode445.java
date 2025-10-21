package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode445 extends ListNode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = true;
        ListNode temp;
        ListNode prev = l1;
        ListNode curr = l1.next;
        while(flag){
            if(curr==null){
                l1.next = curr;
                l1 = prev;
                flag = false;
            } else {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }

        flag = true;
        prev = l2;
        curr = l2.next;
        while(flag){
            if(curr==null){
                l2.next = curr;
                l2 = prev;
                flag = false;
            } else {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        int carry = 0;
        ListNode res = null;
        while(l1!=null || l2!=null){
            if(l1==null){
                res = new ListNode((l2.val+carry)%10,res);
                carry = (l2.val+carry)/10;
                l2=l2.next;
            } else if(l2==null){
                res = new ListNode((l1.val+carry)%10,res);
                carry = (l1.val+carry)/10;
                l1 = l1.next;
            } else {
                res = new ListNode((l1.val+l2.val+carry)%10,res);
                carry = (l1.val+l2.val+carry)/10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(carry>0)
            res = new ListNode(carry,res);
        return res;
    }

}
