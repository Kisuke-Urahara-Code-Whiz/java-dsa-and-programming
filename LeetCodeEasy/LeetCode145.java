package LeetCodeEasy;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorder(root);
        }
        return result;
    }

    private void postorder(TreeNode node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            result.add(node.val);
        }
    }
}
