package LeetCodeEasy;

import Programs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode222 {

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            count+=1;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return count;
    }
}
