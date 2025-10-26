package LeetCodeMedium;

import Programs.TreeNode;

import java.util.*;

public class LeetCode103 extends TreeNode {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        int levelLength = queue.size();
        int l = -1;
        while(levelLength!=0){
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<levelLength;i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(l==-1){
                    if(node.left!=null)
                        stack.push(node.left);
                    if(node.right!=null)
                        stack.push(node.right);
                } else {
                    if(node.right!=null)
                        stack.push(node.right);
                    if(node.left!=null)
                        stack.push(node.left);
                }
            }
            while(!stack.isEmpty())
                queue.offer(stack.pop());
            res.add(levelList);
            levelLength = queue.size();
            l*=-1;
        }
        return res;
    }

}
