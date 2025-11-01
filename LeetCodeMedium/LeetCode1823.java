//This a queue based approach -> There is a game pattern with O(N) T.C and O(1) S.C
//T.C -> O(NK)

package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        if(n==1)
            return 1;
        for(int i=1; i<=n; i++){
            queue.add(i);
        }
        while(queue.size()!=1){
            for(int i=1;i<k;i++){
                queue.add(queue.remove());
            }
            queue.remove();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        LeetCode1823 obj = new LeetCode1823();
        for(int i=1; i<=10; i++){
            for(int j=1;j<=i;j++){
                System.out.println("N = "+i+" , K = "+j+" -> "+obj.findTheWinner(i, j));
            }
        }
    }
}
