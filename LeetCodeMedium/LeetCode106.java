package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode106 extends TreeNode {

    int x;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        x = inorder.length - 1;
        return build(postorder,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] postorder, int[] inorder, int p, int q){
        boolean flag = true;
        int a = p;
        while(a<=q && flag){
            if(postorder[x]==inorder[a])
                flag = false;
            else
                a+=1;
        }
        if(!flag){
            TreeNode curr = new TreeNode(postorder[x]);
            int r = a-1;
            int l = a+1;
            if(l<=q){
                x-=1;
                curr.right = build(postorder, inorder, l, q);
            }
            if(r>=p) {
                x-=1;
                curr.left = build(postorder, inorder, p, r);
            }
            return curr;
        }
        return null;
    }

}
