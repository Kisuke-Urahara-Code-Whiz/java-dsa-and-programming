package LeetCodeMedium;

import Programs.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode817 extends ListNode {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i:nums){
            hashSet.add(i);
        }
        int streak = 0;
        int sum = 0;
        while(head!=null){
            if(hashSet.contains(head.val)){
                if(streak==0) streak = 1;
            } else {
                if(streak>0) {
                    streak = 0;
                    sum+=1;
                }
            }
            head = head.next;
        }
        if(streak>0)
            sum+=1;
        return sum;
    }
}
