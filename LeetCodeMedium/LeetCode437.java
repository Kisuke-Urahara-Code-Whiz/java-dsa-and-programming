package LeetCodeMedium;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode437 extends TreeNode {

    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        Deque<Long> deque = new LinkedList<>();
        findPaths(root, deque, (long)targetSum);
        return result;
    }

    private void findPaths(TreeNode node, Deque<Long> deque, long targetSum){
        int size = deque.size();
        while(size!=0){
            long n = deque.remove();
            n-=node.val;
            if(n==0) result+=1;
            deque.add(n);
            size-=1;
        }
        long val = targetSum-node.val;
        if(val==0) result+=1;
        deque.add(val);
        if(node.left!=null) findPaths(node.left, deque, targetSum);
        if(node.right!=null) findPaths(node.right, deque, targetSum);
        deque.removeLast();
        size = deque.size();
        while(size!=0){
            deque.add(deque.remove()+ node.val);
            size-=1;
        }
    }

    static void main(){
        LeetCode437 obj = new LeetCode437();
        TreeNode root = obj.buildTree(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
        System.out.println("Answer -> "+obj.pathSum(root,0));
    }
}