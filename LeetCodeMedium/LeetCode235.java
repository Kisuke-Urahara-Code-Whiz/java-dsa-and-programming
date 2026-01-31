package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode235{

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        else{
            TreeNode lca = root==p || root==q?root:null;
            TreeNode right = lowestCommonAncestor(root.left, p, q);
            TreeNode left = lowestCommonAncestor(root.right, p, q);
            if(left!=null && right!=null) lca=root;
            else if(right==null) lca=lca==null?left:lca;
            else lca=lca==null?right:lca;
            return lca;
        }
    }

}
