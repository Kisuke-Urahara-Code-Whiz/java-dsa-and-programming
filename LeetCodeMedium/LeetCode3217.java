package LeetCodeMedium;

import Programs.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3217 extends ListNode {

    Set<Integer> arr = new HashSet<>();

    public ListNode modifiedList(int[] nums, ListNode head) {
        for(int i:nums){
            arr.add(i);
        }

        ListNode res = new ListNode();
        ListNode temp = res;
        temp.next = head;
        while(temp.next!=null){
            if(arr.contains(temp.next.val))
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return res.next;
    }

}
