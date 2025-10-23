package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode725 extends ListNode {

    int nSplit = 0;
    int index;
    int lIndex;
    int n;

    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] arr = new int[]{k,0,0,0,k-1,0};
        index = k-1;
        ListNode[] res = new ListNode[k];
        split(k,head,0, res);
        return res;
    }

    public void split(int k, ListNode curr,int length, ListNode[] res) {
        if(curr!=null){
            split(k,curr.next, length+1, res);
            if(lIndex==1)
                curr.next=null;
            if(lIndex==nSplit && n>0){
                res[index--] = curr;
                lIndex = 1;
                n-=1;
            } else if(lIndex==nSplit+1 && n==0){
                res[index--] = curr;
                lIndex = 1;
            } else {
                lIndex+=1;
            }
        }
        else{
            nSplit = length/k;
            n = k - (length%k);
            if(nSplit==0){
                while(n>0){
                    res[index--] = null;
                    n-=1;
                }
            }
            lIndex = 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        LeetCode725 obj = new LeetCode725();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int k = 6;
        ListNode[] res = obj.splitListToParts(head,6);
        for(int i=0;i<k;i++){
            System.out.println("Split Part "+(i+1)+" -> ");
            obj.displayLinkedList(res[i]);
        }
    }

}
