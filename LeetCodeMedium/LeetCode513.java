package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

import Programs.TreeNode;

public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = -1;
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            boolean flag = false;
            while(levelLength!=0){
                TreeNode node = queue.remove();
                if(!flag){
                    result = node.val;
                    flag = true;
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                levelLength-=1;
            }
            levelLength = queue.size();
        }
        return result;
    }

}
