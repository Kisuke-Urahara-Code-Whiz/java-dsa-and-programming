package LeetCodeMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Programs.TreeNode;

public class LeetCode2196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            if (isLeft) nodeMap.get(parentVal).left = nodeMap.get(childVal);
            else nodeMap.get(parentVal).right = nodeMap.get(childVal);

            children.add(childVal);
        }

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }

        return null;
    }
}