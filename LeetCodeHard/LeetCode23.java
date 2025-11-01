package LeetCodeHard;

import Programs.ListNode;

public class LeetCode23 extends ListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int len = lists.length;
        boolean flag = true;
        while(flag){
            int i = 0;
            int index = -1 ;
            for(int k=0;k<len;k++){
                if(lists[k]==null){
                    i+=1;
                } else if(index==-1){
                    index = k;
                } else if(lists[index].val>lists[k].val){
                    index = k;
                }

            }
            if(i==len)
                flag = false;
            else{
                temp.next = lists[index];
                lists[index] = lists[index].next;
                temp = temp.next;
                temp.next = null;
            }
        }
        return res.next;
    }

}
