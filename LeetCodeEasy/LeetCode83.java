package LeetCodeEasy;

public class LeetCode83 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        else{
            int value = head.val;
            remove(head,value,head.next);
            return head;
        }
    }

    public void remove(ListNode temp, int value, ListNode tempNext){
        if(tempNext.next!=null){
            if(tempNext.val!=value)
                remove(tempNext, tempNext.val,tempNext.next);
            else {
                temp.next = tempNext.next;
                remove(temp, value, temp.next);
            }
        }
        else{
            if(tempNext.val==value)
                temp.next = tempNext.next;
        }
    }

}
