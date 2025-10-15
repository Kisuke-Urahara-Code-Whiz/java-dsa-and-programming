package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode328 extends ListNode {
    public ListNode oddEvenList(ListNode head) {
        if(head!=null){
            ListNode first = head;
            ListNode second = head.next;
            if(second!=null){
                ListNode temp1 = first;
                ListNode temp2 = second;
                boolean flag = true;
                while(flag){
                    if(temp2.next!=null){
                        temp1.next = temp2.next;
                        temp1 = temp1.next;
                        if(temp1.next!=null){
                            temp2.next = temp1.next;
                            temp2 = temp2.next;
                        } else {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }
                temp1.next = second;
                temp2.next = null;
            }
        }
        return head;
    }
}
