package Others;

//GFG Medium
//Row Major traversal for every intermediate node taken
public class FloydWarshall {

    private static final int INF = (int)Math.pow(10,8);

    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=INF && dist[k][j]!=INF){
                        int actualDistance = dist[i][j];
                        int tempDistance = dist[i][k] + dist[k][j];
                        if(tempDistance<actualDistance) dist[i][j] = tempDistance;
                    }
                }
            }
        }
    }

}
