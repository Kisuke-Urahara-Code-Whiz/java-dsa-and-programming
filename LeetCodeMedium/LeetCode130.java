package LeetCodeMedium;

public class LeetCode130 {

    static class Queue {

        int flag;
        int front;
        int rear;
        int[] arr;
        int length;
        int currLength;

        public Queue(int k) {

            this.flag = -1;
            this.front = 0;
            this.rear = 0;
            this.arr = new int[k];
            this.length = k;

        }

        public void enQueue(int value) {
            if(!isFull()){
                arr[rear] = value;
                rear = (rear+1)%length;
                flag = rear==front? 1 : 0;
            }
        }

        public int deQueue() {
            if(!isEmpty()){
                int result = arr[front];
                front = (front+1)%length;
                flag = front==rear? -1 : 0;
                return result;
            } return -1;
        }

        public boolean isEmpty() {
            return flag==-1;
        }

        private boolean isFull() {
            return flag==1;
        }

        public int findLength(){
            if(isEmpty()) return 0;
            else if(isFull()) return length;
            else if(front<rear) return rear-front;
            else return (length-front)+rear;
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue xQueue = new Queue(m*n);
        Queue yQueue = new Queue(m*n);
        int[][] movements = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for(int i: new int[]{0,m-1}) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    visited[i][j] = true;
                    xQueue.enQueue(i);
                    yQueue.enQueue(j);
                }
            }
        }

        int[] columnTraverse = new int[]{0, n-1};

        for(int i=1;i<(m-1);i++){
            for(int j: columnTraverse){
                if (board[i][j] == 'O') {
                    visited[i][j] = true;
                    xQueue.enQueue(i);
                    yQueue.enQueue(j);
                }
            }
        }

        int levelLength = xQueue.findLength();

        while(!xQueue.isEmpty()){
            while(levelLength!=0){
                int x = xQueue.deQueue();
                int y = yQueue.deQueue();
                for(int[] i: movements){
                    int tempX = x+i[0];
                    int tempY = y+i[1];
                    if(tempX>=0 && tempX<m && tempY>=0 && tempY<n && !visited[tempX][tempY] && board[tempX][tempY]=='O') {
                        visited[tempX][tempY] = true;
                        xQueue.enQueue(tempX);
                        yQueue.enQueue(tempY);
                    }
                }
                levelLength-=1;
            }
            levelLength = xQueue.findLength();
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode130 obj = new LeetCode130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        obj.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}
