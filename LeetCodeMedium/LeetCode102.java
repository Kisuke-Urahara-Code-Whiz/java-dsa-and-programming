package LeetCodeMedium;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 extends TreeNode {

    //DFS
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

    //BFS
    public List<List<Integer>> printLevelBFS(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            System.out.println("No elements to print");
        } else {
            List<Integer> levelList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelSize =  queue.size();
                for(int i=0;i<levelSize;i++){
                    TreeNode node = queue.poll();
                    levelList.add(node.val);
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                list.add(levelList);
                levelList = new ArrayList<>();
            }
        }
        return list;
    }
}
