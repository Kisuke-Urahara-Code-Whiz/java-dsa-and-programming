package LeetCodeMedium;

import java.util.HashMap;

public class LeetCode146 {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache;
    private int capacity;

    private Node head;
    private Node tail;

    public LeetCode146(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        removeNode(node);
        addNodeToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        } else {
            if (cache.size() == capacity) {
                Node lruNode = tail.prev;
                cache.remove(lruNode.key);
                removeNode(lruNode);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    private void addNodeToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        LeetCode146 lRUCache = new LeetCode146(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}