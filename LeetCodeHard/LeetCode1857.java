package LeetCodeHard;

import java.util.*;

//Used Topological Sort
//Solved the question in first try
//Crazy solution
//Adding Comment Lines because it is a pretty hard question
public class LeetCode1857 {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(); // Number of nodes
        int m = edges.length; // Number of edges
        if(m==0) return 1; // If edges count = 1, then largest color value along a path is 1 too.
        if(n==1 && m==1) return -1; // If edges count is 1, and node count is 1, its bound to be a cycle.

        int colorLength = 0;
        HashMap<Character, Integer> colorIndexMap = new HashMap<>();
        char[] col = colors.toCharArray();
        for(char c: col){
            if(!colorIndexMap.containsKey(c)) colorIndexMap.put(c, colorLength++);
        } // Finding how many unique colours are there and plotting there indexes in a Hashmap

        int traversed = 0; // To keep a track how many nodes I traversed, for cycle detection
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Queue<Integer> nodeQueue = new LinkedList<>();
        int[] indegree = new int[n]; // To keep a track of indegree of nodes
        int[][] colorVal = new int[n][colorLength]; // To keep a track of the max value of each color of all the paths till this node
        int result = 0;

        for(int[] i: edges){
            ArrayList<Integer> list = graph.getOrDefault(i[0], null);
            if(list==null){
                list = new ArrayList<>();
                graph.put(i[0], list);
            }
            list.add(i[1]);
            indegree[i[1]] += 1;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0) {
                nodeQueue.add(i);
                int[] colorArr = colorVal[i];
                colorArr[colorIndexMap.get(col[i])]+=1;
                traversed+=1;
            }
        } // Add the nodes in queue with 0 indegree

        //Basic Kahn's Algorithm logic remains exactly the same
        int levelLength = nodeQueue.size();
        while(!nodeQueue.isEmpty()){
            while(levelLength!=0){
                int node = nodeQueue.remove();
                int[] colorArr = colorVal[node];
                for(int j: colorArr){
                    result = Math.max(result, j);
                }
                ArrayList<Integer> connections = graph.getOrDefault(node, null);
                if(connections!=null){
                    for(int i: connections){
                        int[] maxColor = colorVal[i];
                        for(int j=0;j<colorLength;j++){
                            maxColor[j] = Math.max(maxColor[j], colorArr[j]);
                        } // Updating the max value of a certain color of all the paths till reaching this node ( Core logic )
                        indegree[i]-=1;
                        if(indegree[i]==0){
                            nodeQueue.add(i);
                            maxColor[colorIndexMap.get(col[i])]+=1;
                            traversed+=1;
                        }
                    }
                }
                levelLength-=1;
            }
            levelLength = nodeQueue.size();
        }

        return traversed==n? result: -1; // Cycle detection
    }

    public static void main(String[] args) {
        LeetCode1857 solver = new LeetCode1857();

        // Test Case 3: The Long Dominant Chain
        System.out.println(solver.largestPathValue(
                "abacaa",
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {0, 5},
                        {5, 4}
                }));

    }

}
