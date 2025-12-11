package Programs;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueueLL {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        System.out.println(deque.getLast());
    }
}
