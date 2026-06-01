package Others;

//GFG - Medium
//Negative Cycle - Return {-1}
//Shortest Path from src to all nodes in an array
//No path from src to node -> mark it 10^8
public class BellmanFord {

    public static final int INF = 1001;

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] shortestPath = new int[V];
        for(int i=0;i<V;i++){
            if(i==src) shortestPath[i] = 0;
            else shortestPath[i] = INF;
        }

        for(int i=1;i<V;i++){
            for(int[] j: edges){
                int tempSrc = j[0];
                int tempDest = j[1];
                int tempWt = j[2];
                if(shortestPath[tempSrc]!=INF && shortestPath[tempSrc]+tempWt < shortestPath[tempDest])
                    shortestPath[tempDest] = shortestPath[tempSrc]+tempWt;
            }
        }


        for(int[] j: edges){
            int tempSrc = j[0];
            int tempDest = j[1];
            int tempWt = j[2];
            if(shortestPath[tempSrc] != INF && shortestPath[tempSrc]+tempWt < shortestPath[tempDest])
                return new int[]{-1};
        }

        for(int i=0;i<V;i++){
            if(shortestPath[i]==INF) shortestPath[i] = (int)Math.pow(10,8);
        }

        return shortestPath;
    }

}
