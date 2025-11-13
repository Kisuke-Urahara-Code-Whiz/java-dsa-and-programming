package LeetCodeMedium;

import Programs.TreeNode;

public class LeetCode105  extends TreeNode {

    int p3 = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int p1 = 0;
        int p2 = 0;
        boolean flag = true;
        while(p2 < inorder.length && flag){
            if(inorder[p2] == preorder[p3])
                flag = false;
            else
                p2+=1;
        }
        if(!flag){
            TreeNode curr = new TreeNode(preorder[p3]);
            int[] arr1 = new int[p2];
            int[] arr2 = new int[inorder.length - p2 - 1];
            for(int i =p1;i<arr1.length;i++){
                arr1[p1++] = inorder[i];
            }
            p1+=1;
            for(int i=0;i< arr2.length;i++){
                arr2[i] = inorder[p1++];
            }
            if(arr1.length>0){
                p3+=1;
                curr.left = buildTree(preorder,arr1);
            }
            if(arr2.length>0){
                p3+=1;
                curr.right = buildTree(preorder,arr2);
            }
            return curr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        LeetCode105 obj = new LeetCode105();
        obj.buildTree(preorder, inorder);
    }
}