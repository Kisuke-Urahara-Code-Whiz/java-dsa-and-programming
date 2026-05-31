package LeetCodeHard;

public class LeetCode778 {

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        if(m==1) return 0;
        boolean[][] visited = new boolean[m][m];
        int x = 0;
        int y = 0;
        int wt = grid[x][y];
        visited[x][y] = true;
        Heap heap = new Heap(m);
        heap.insert(x,y,wt);
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int timer = wt;
        while(!heap.isEmpty()){
            while(heap.peekWeight()<=timer) {
                int[] top = heap.delete();
                x = top[0];
                y = top[1];
                if(x==m-1 && y==m-1) return timer;
                for(int[] i: directions){
                    int newX = x+i[0];
                    int newY = y+i[1];
                    if(newX>=0 && newX<m && newY>=0 && newY<m && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        heap.insert(newX, newY, grid[newX][newY]);
                    }
                }
            }
            timer+=1;
        }
        return -1;
    }

    private static class Heap{

        int[] x;
        int[] y;
        int[] weights;
        int length;
        int top;

        Heap(int length){
            this.length = length*length;
            this.x = new int[this.length+1];
            this.y = new int[this.length+1];
            this.weights = new int[this.length+1];
            this.top = 1;
        }

        private void swap(int p1, int p2){

            int temp;

            temp = weights[p1];
            weights[p1] = weights[p2];
            weights[p2] = temp;

            if(x[p1] != x[p2]) {
                temp = x[p1];
                x[p1] = x[p2];
                x[p2] = temp;
            }

            if(y[p1] != y[p2]) {
                temp = y[p1];
                y[p1] = y[p2];
                y[p2] = temp;
            }

        }

        public void insert(int x, int y, int wt){
            weights[top] = wt;
            this.x[top] = x;
            this.y[top] = y;
            int tempIndex = top++;

            while(tempIndex!=1 && weights[tempIndex/2]>weights[tempIndex]){
                swap(tempIndex, tempIndex/2);
                tempIndex = tempIndex/2;
            }
        }

        public int peekWeight(){
            if(top==1) return -1;
            return weights[1];
        }

        public int[] delete(){
            if(top!=1){
                int x = this.x[1];
                int y = this.y[1];

                swap(1, top-1);
                top = top-1;

                int tempIndex = 1;
                while(tempIndex*2<top){
                    int lIndex = tempIndex*2;
                    if(lIndex+1<top && weights[lIndex]>weights[lIndex+1]) lIndex+=1;
                    if(weights[lIndex]<weights[tempIndex]){
                        swap(lIndex, tempIndex);
                        tempIndex = lIndex;
                    } else break;
                }
                return new int[]{x,y};
            }
            return new int[]{};
        }

        public boolean isEmpty(){
            return top==1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode778().swimInWater(new int[][]{
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        }));
    }

}
