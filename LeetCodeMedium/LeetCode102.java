package LeetCodeMedium;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode102 extends TreeNode {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        } else {
            printLevel(root,0,list);
            return list;
        }
    }

    private void printLevel(TreeNode node,int level,List<List<Integer>> list){
        if(node!=null){
            if(list.size()==level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);
            printLevel(node.left,level+1,list);
            printLevel(node.right,level+1,list);
        }
    }

}
