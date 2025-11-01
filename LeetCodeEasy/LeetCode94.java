package LeetCodeEasy;

import Programs.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode94{

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorder(root);
        }
        return result;
    }

    private void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            result.add(node.val);
            inorder(node.right);
        }
    }

}
