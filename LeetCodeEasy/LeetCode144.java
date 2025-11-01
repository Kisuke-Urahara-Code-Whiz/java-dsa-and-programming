package LeetCodeEasy;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            preorder(root);
        }
        return result;
    }

    private void preorder(TreeNode node){
        if(node!=null){
            result.add(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
