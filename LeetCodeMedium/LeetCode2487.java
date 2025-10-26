package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode2487 extends ListNode {

    public ListNode removeNodes(ListNode head) {
        if(head==null){
            return null;
        }
        else{
            ListNode temp = removeNodes(head.next);
            if(temp==null){
                temp = head;
            }
            else if(head.val>=temp.val){
                head.next = temp;
                temp = head;
            }
            return temp;
        }
    }

}
