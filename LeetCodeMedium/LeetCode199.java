package LeetCodeMedium;

import Programs.TreeNode;

import java.util.*;

public class LeetCode199 extends TreeNode {

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            for(int i=1;i<=levelLength;i++){
                TreeNode curr = queue.poll();
                if(i==1)
                    levels.add(curr.val);
                if(curr.right!=null) queue.add(curr.right);
                if(curr.left!=null) queue.add(curr.left);
            }
            levelLength = queue.size();
        }
        return levels;
    }

}
